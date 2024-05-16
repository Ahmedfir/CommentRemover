

package us.jts.fortress.rbac;

import us.jts.fortress.util.time.CUtil;
import us.jts.fortress.util.time.Constraint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@XmlRootElement(name = "fortRole")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "role", propOrder = {
    "name",
    "id",
    "description",
    "parents",
    "children",
    "beginDate",
    "beginLockDate",
    "beginTime",
    "dayMask",
    "endDate",
    "endLockDate",
    "endTime",
    "timeout",
    "rawData"
})
@XmlSeeAlso({
    AdminRole.class
})
public class Role extends FortEntity
    implements Constraint, Graphable, java.io.Serializable
{
    private String id;          
    private String name;          
    private String description; 
    @XmlTransient
    private String dn;          
    @XmlTransient
    private List<String> occupants;
    private Set<String> parents;
    private Set<String> children;
    private String beginTime;     
    private String endTime;        
    private String beginDate;    
    private String endDate;        
    private String beginLockDate;
    private String endLockDate;    
    private String dayMask;        
    private int timeout;        

    
    public Role()
    {
    }

    
    public Role(String name)
    {
        this.name = name;
    }

    
    public Role(us.jts.fortress.util.time.Constraint con)
    {
        CUtil.copy(con, this);
    }

    
    public String getRawData()
    {
        return rawData;
    }

    
    public void setRawData(String rawData)
    {
        this.rawData = rawData;
    }

    private String rawData;

    
    public String getName()
    {
        return this.name;
    }

    
    public void setName(String name)
    {
        this.name = name;
    }

    
    public void setOccupant(String occupant)
    {
        if (this.occupants == null)
        {
            this.occupants = new ArrayList<>();
        }
        this.occupants.add(occupant);
    }

    
    public List<String> getOccupants()
    {
        return occupants;
    }

    
    public void setOccupants(List<String> occupants)
    {
        this.occupants = occupants;
    }

    
    public String getDescription()
    {
        return this.description;
    }

    
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public String getId()
    {
        return id;
    }

    
    public void setId()
    {

        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    
    public void setId(String id)
    {
        this.id = id;
    }

    
    @Override
    public boolean isTemporalSet()
    {
        return (beginTime != null && endTime != null && beginDate != null && endDate != null && beginLockDate != null && endLockDate != null && dayMask != null);
    }


    
    @Override
    public String getBeginTime()
    {
        return this.beginTime;
    }

    
    @Override
    public void setBeginTime(String beginTime)
    {
        this.beginTime = beginTime;
    }

    
    @Override
    public String getEndTime()
    {
        return this.endTime;
    }

    
    @Override
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    
    @Override
    public String getBeginDate()
    {
        return this.beginDate;
    }

    
    @Override
    public void setBeginDate(String beginDate)
    {
        this.beginDate = beginDate;
    }

    
    @Override
    public String getEndDate()
    {
        return this.endDate;
    }

    
    @Override
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    
    @Override
    public String getBeginLockDate()
    {
        return this.beginLockDate;
    }

    
    @Override
    public void setBeginLockDate(String beginLockDate)
    {
        this.beginLockDate = beginLockDate;
    }

    
    @Override
    public String getEndLockDate()
    {
        return this.endLockDate;
    }

    
    @Override
    public void setEndLockDate(String endLockDate)
    {
        this.endLockDate = endLockDate;
    }

    
    @Override
    public String getDayMask()
    {
        return this.dayMask;
    }

    
    @Override
    public void setDayMask(String dayMask)
    {
        this.dayMask = dayMask;
    }

    
    @Override
    public Integer getTimeout()
    {
        return this.timeout;
    }

    
    @Override
    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }

    
    @Override
    public Set<String> getParents()
    {
        return parents;
    }

    
    @Override
    public void setParents(Set<String> parents)
    {
        this.parents = parents;
    }

    
    @Override
    public void setParent(String parent)
    {
        if (this.parents == null)
        {
            this.parents = new HashSet<>();
        }
        this.parents.add(parent);
    }

    
    @Override
    public void delParent(String parent)
    {
        if (this.parents != null)
        {
            this.parents.remove(parent);
        }
    }

    
    public Set<String> getChildren()
    {
        return children;
    }

    
    public void setChildren(Set<String> children)
    {
        this.children = children;
    }

    
    public boolean equals(Object thatObj)
    {
        if (this == thatObj) return true;
        if (this.getName() == null) return false;
        if (!(thatObj instanceof Role)) return false;
        Role thatRole = (Role) thatObj;
        if (thatRole.getName() == null) return false;
        return thatRole.getName().equalsIgnoreCase(this.getName());
    }
}

