package com.commentremover;

import com.commentremover.app.CommentProcessor;
import com.commentremover.app.CommentRemover;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class RemoveComments {

    private static final String VALID_ARGS_MSG = "You must pass one arguments <path to input directory>";

    public static void main(String... args) {
        try {
            if (args == null || args.length != 1 || args[0] == null || args[0].isEmpty()) {
                System.err.println(VALID_ARGS_MSG + "\nYou passed:\n" + Arrays.toString(args));
                System.exit(101);
            }

            CommentRemover commentRemover = new CommentRemover.CommentRemoverBuilder()
                    .removeJava(true) // Remove Java file Comments....
                    .removeJavaScript(true) // Remove JavaScript file Comments....
                    .removeJSP(true) // etc..
                    .removeTodos(true) // Remove todos
                    .removeSingleLines(true) // Do not remove single line type comments
                    .removeMultiLines(true) // Remove multiple type comments
                    .preserveJavaClassHeaders(false) // Preserves class header comment
                    .preserveCopyRightHeaders(false) // Preserves copyright comment
                    .startExternalPath(args[0])// Give it full path for external directories
                    .build();

            CommentProcessor commentProcessor = new CommentProcessor(commentRemover);

            commentProcessor.start();
        } catch (Throwable throwable) {
            System.err.println("Failed = " + Arrays.toString(args));
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
            System.err.println(sw);
            System.exit(100);
        }
    }


}
