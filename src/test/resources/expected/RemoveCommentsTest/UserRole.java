

package us.jts.fortress.rbac;

import us.jts.fortress.GlobalIds;
import us.jts.fortress.util.time.CUtil;
import us.jts.fortress.util.time.Constraint;

import javax.xml.bind.annotation.*;
import java.util.Set;
import java.util.StringTokenizer;


@XmlRootElement(name = "fortUserRole")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userRole", propOrder = {
    "name",
    "userId",
    "parents",
    "beginDate",
    "beginLockDate",
    "beginTime",
    "dayMask",
    "endDate",
    "endLockDate",
    "endTime",
    "timeout"
})
@XmlSeeAlso({
    UserAdminRole.class
})
public class UserRole extends FortEntity implements java.io.Serializable, Constraint
{
    protected String userId;
    protected String name;
    private Integer timeout;
    private String beginTime;
    private String endTime;
    private String beginDate;
    private String endDate;
    private String beginLockDate;
    private String endLockDate;
    private String dayMask;
    @XmlElement(nillable = true)
    private Set<String> parents;

    
    public UserRole()
    {
    }

    
    public UserRole(String userId, String role)
    {
        this.userId = userId;
        this.name = role;

    }

    
    public UserRole(String userId, Constraint con)
    {
        this.userId = userId;
        CUtil.copy(con, this);
    }

    
    public UserRole(String role)
    {
        this.name = role;
    }

    
    public void load(String szRawData, String contextId)
    {
        if (szRawData != null && szRawData.length() > 0)
        {
            StringTokenizer tkn = new StringTokenizer(szRawData, GlobalIds.DELIMITER);
            if (tkn.countTokens() > 0)
            {
                int count = tkn.countTokens();
                for (int i = 0; i < count; i++)
                {
                    switch (i)
                    {
                        case 0:
                            this.setName(tkn.nextToken());
                            this.setParents(RoleUtil.getParents(this.name.toUpperCase(), contextId));
                            break;
                        case 1:
                            this.setTimeout(Integer.parseInt(tkn.nextToken()));
                            break;
                        case 2:
                            this.setBeginTime(tkn.nextToken());
                            break;
                        case 3:
                            this.setEndTime(tkn.nextToken());
                            break;
                        case 4:
                            this.setBeginDate(tkn.nextToken());
                            break;
                        case 5:
                            this.setEndDate(tkn.nextToken());
                            break;
                        case 6:
                            this.setBeginLockDate(tkn.nextToken());
                            break;
                        case 7:
                            this.setEndLockDate(tkn.nextToken());
                            break;
                        case 8:
                            this.setDayMask(tkn.nextToken());
                            break;
                    }
                }
            }
        }
    }

    
    @Override
    public String getRawData()
    {
        String szRole;
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());
        sb.append(GlobalIds.DELIMITER);
        sb.append(this.getTimeout());
        sb.append(GlobalIds.DELIMITER);
        if (this.getBeginTime() != null)
            sb.append(this.getBeginTime());
        sb.append(GlobalIds.DELIMITER);
        if (this.getEndTime() != null)
            sb.append(this.getEndTime());
        sb.append(GlobalIds.DELIMITER);
        if (this.getBeginDate() != null)
            sb.append(this.getBeginDate());
        sb.append(GlobalIds.DELIMITER);
        if (this.getEndDate() != null)
            sb.append(this.getEndDate());
        sb.append(GlobalIds.DELIMITER);
        if (this.getBeginLockDate() != null)
            sb.append(this.getBeginLockDate());
        sb.append(GlobalIds.DELIMITER);
        if (this.getEndLockDate() != null)
            sb.append(this.getEndLockDate());
        sb.append(GlobalIds.DELIMITER);
        if (this.getDayMask() != null)
            sb.append(this.getDayMask());
        szRole = sb.toString();
        return szRole;
    }

    
    public String toString()
    {
        return name;
    }

    
    public String getUserId()
    {
        return userId;
    }

    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    
    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    
    @Override
    public String getName()
    {
        return name;
    }

    
    @Override
    public boolean isTemporalSet()
    {
        return (beginTime != null && endTime != null && beginDate != null && endDate != null && beginLockDate != null && endLockDate != null && dayMask != null);
    }

    
    @Override
    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }


    
    @Override
    public void setBeginTime(String beginTime)
    {
        this.beginTime = beginTime;
    }


    
    @Override
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }


    
    @Override
    public void setBeginDate(String beginDate)
    {
        this.beginDate = beginDate;
    }


    
    @Override
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }


    
    @Override
    public void setDayMask(String dayMask)
    {
        this.dayMask = dayMask;
    }


    
    @Override
    public void setBeginLockDate(String beginLockDate)
    {
        this.beginLockDate = beginLockDate;
    }


    
    @Override
    public void setEndLockDate(String endLockDate)
    {
        this.endLockDate = endLockDate;
    }


    
    @Override
    public Integer getTimeout()
    {
        return this.timeout;
    }


    
    @Override
    public String getBeginTime()
    {
        return this.beginTime;
    }


    
    @Override
    public String getEndTime()
    {
        return this.endTime;
    }


    
    @Override
    public String getBeginDate()
    {
        return this.beginDate;
    }


    
    @Override
    public String getEndDate()
    {
        return this.endDate;
    }


    
    @Override
    public String getBeginLockDate()
    {
        return beginLockDate;
    }


    
    @Override
    public String getEndLockDate()
    {
        return endLockDate;
    }

    
    @Override
    public String getDayMask()
    {
        return this.dayMask;
    }

    
    public Set<String> getParents()
    {
        return parents;
    }

    
    public void setParents(Set<String> parents)
    {
        this.parents = parents;
    }

    
    public boolean equals(Object thatObj)
    {
        if (this == thatObj) return true;
        if (this.getName() == null) return false;
        if (!(thatObj instanceof UserRole)) return false;
        UserRole thatRole = (UserRole) thatObj;
        if (thatRole.getName() == null) return false;

        return (thatRole.getName().equalsIgnoreCase(this.getName()));
    }
}

