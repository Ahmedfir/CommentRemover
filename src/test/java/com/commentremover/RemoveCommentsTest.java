package com.commentremover;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class RemoveCommentsTest {

    private static final String FILE_1 = "src/test/resources/javafile/Role.java";
    private static final String FILE_2 = "src/test/resources/javafile/User.java";
    private static final String FILE_3 = "src/test/resources/javafile/UserRole.java";



    private static Path outputDir;
    private static Path outputDirF1;
    private static Path outputDirF2;
    private static Path outputDirF3;
    private static Path expectedDir;
    private static Path expectedDirF1;
    private static Path expectedDirF2;
    private static Path expectedDirF3;

    @BeforeClass
    public static void beforeClass() throws Exception {
        expectedDir = Paths.get("src/test/resources/expected").resolve(RemoveCommentsTest.class.getSimpleName());
        outputDir = Paths.get("src/test/resources/tmp").resolve(RemoveCommentsTest.class.getSimpleName());
        Path outPath = Files.createDirectories(outputDir);

        Path srcPathF1 = Paths.get(FILE_1);
        Path srcPathF2 = Paths.get(FILE_2);
        Path srcPathF3 = Paths.get(FILE_3);
        outputDirF1 = outPath.resolve(srcPathF1.getFileName());
        outputDirF2 = outPath.resolve(srcPathF2.getFileName());
        outputDirF3 = outPath.resolve(srcPathF3.getFileName());

        expectedDirF1 = expectedDir.resolve(srcPathF1.getFileName());
        expectedDirF2 = expectedDir.resolve(srcPathF2.getFileName());
        expectedDirF3 = expectedDir.resolve(srcPathF3.getFileName());

        Files.copy(srcPathF1, outputDirF1);
        Files.copy(srcPathF2, outputDirF2);
        Files.copy(srcPathF3, outputDirF3);

    }


    @Test
    public void testMain() throws IOException {
        RemoveComments.main(outputDir.toString());
        assertTrue("The files differ!", FileUtils.contentEquals(expectedDirF1.toFile(), outputDirF1.toFile()));
        assertTrue("The files differ!", FileUtils.contentEquals(expectedDirF2.toFile(), outputDirF2.toFile()));
        assertTrue("The files differ!", FileUtils.contentEquals(expectedDirF3.toFile(), outputDirF3.toFile()));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        FileUtils.deleteDirectory(outputDir.toFile());
    }
}