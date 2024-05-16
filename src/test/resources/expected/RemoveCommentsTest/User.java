

package us.jts.fortress.rbac;

import us.jts.fortress.util.time.Constraint;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.*;




@XmlRootElement(name = "fortUser")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "userId",
    "description",
    "name",
    "internalId",
    "ou",
    "pwPolicy",
    "sn",
    "cn",
    "dn",
    "employeeType",
    "title",
    "address",
    "phones",
    "mobiles",
    "emails",
    "props",
    "locked",
    "reset",
    "system",
    "beginTime",
    "endTime",
    "beginDate",
    "endDate",
    "beginLockDate",
    "endLockDate",
    "dayMask",
    "timeout",
    "roles",
    "adminRoles",
    "password",
    "newPassword"
})
public class User extends FortEntity implements Constraint, Serializable
{
    private String userId;
    @XmlElement(nillable = true)
    private char[] password;
    @XmlElement(nillable = true)
    private char[] newPassword;
    private String internalId;
    @XmlElement(nillable = true)
    private List<UserRole> roles;
    @XmlElement(nillable = true)
    private List<UserAdminRole> adminRoles;
    private String pwPolicy;
    private String cn;
    private String sn;
    private String dn;
    private String ou;
    private String description;
    private String beginTime;
    private String endTime;
    private String beginDate;
    private String endDate;
    private String beginLockDate;
    private String endLockDate;
    private String dayMask;
    private String name;
    private String employeeType;
    private String title;
    private int timeout;
    private boolean reset;
    private boolean locked;
    private Boolean system;
    @XmlElement(nillable = true)
    private Props props = new Props();
    @XmlElement(nillable = true)
    private Address address;
    @XmlElement(nillable = true)
    private List<String> phones;
    @XmlElement(nillable = true)
    private List<String> mobiles;
    @XmlElement(nillable = true)
    private List<String> emails;

    
    public User()
    {
    }

    
    public User(String userId)
    {
        this.userId = userId;
    }

    
    public User(String userId, char[] password)
    {
        this.userId = userId;
        this.password = password;
    }

    
    public User(String userId, char[] password, String roleName)
    {
        this.userId = userId;
        this.password = password;
        setRole(new UserRole(roleName));
    }

    
    public User(String userId, char[] password, String[] roleNames)
    {
        this.userId = userId;
        this.password = password;
        if (roleNames != null)
        {
            for (String name : roleNames)
            {
                setRole(new UserRole(name));
            }
        }
    }

    
    public User(String userId, char[] password, String roleName, String ou)
    {
        this.userId = userId;
        this.password = password;
        setRole(new UserRole(roleName));
        this.ou = ou;
    }

    
    public String toString()
    {
        return userId;
    }

    
    public String getRawData()
    {
        throw new UnsupportedOperationException("not allowed for user");
    }

    
    public String getName()
    {
        return name;
    }

    
    public void setName(String name)
    {
        this.name = name;
    }

    
    public String getEmployeeType()
    {
        return employeeType;
    }

    
    public void setEmployeeType(String employeeType)
    {
        this.employeeType = employeeType;
    }

    
    public String getTitle()
    {
        return title;
    }

    
    public void setTitle(String title)
    {
        this.title = title;
    }

    
    public String getPwPolicy()
    {
        return pwPolicy;
    }

    
    public void setPwPolicy(String pwPolicy)
    {
        this.pwPolicy = pwPolicy;
    }

    
    public List<UserRole> getRoles()
    {

        if (roles == null)
        {
            roles = new ArrayList<>();
        }
        return roles;
    }

    
    public void setRoles(List<UserRole> roles)
    {
        this.roles = roles;
    }

    
    public void setRole(UserRole role)
    {
        if (roles == null)
        {
            roles = new ArrayList<>();
        }
        roles.add(role);
    }

    
    public void setRole(String roleName)
    {
        if (roles == null)
        {
            roles = new ArrayList<>();
        }
        roles.add(new UserRole(roleName));
    }

    
    public void delRole(UserRole role)
    {
        if (roles != null)
        {
            roles.remove(role);
        }
    }

    
    public List<UserAdminRole> getAdminRoles()
    {

        if (adminRoles == null)
        {
            adminRoles = new ArrayList<>();
        }
        return adminRoles;
    }

    
    public void setAdminRoles(List<UserAdminRole> roles)
    {
        this.adminRoles = roles;
    }

    
    public void setAdminRole(UserAdminRole role)
    {
        if (adminRoles == null)
        {
            adminRoles = new ArrayList<>();
        }
        adminRoles.add(role);
    }

    
    public void setAdminRole(String roleName)
    {
        if (adminRoles == null)
        {
            adminRoles = new ArrayList<>();
        }
        adminRoles.add(new UserAdminRole(this.userId, roleName));
    }

    
    public String getUserId()
    {
        return this.userId;
    }

    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }


    
    public String getInternalId()
    {
        return this.internalId;
    }

    
    public void setInternalId(String internalId)
    {
        this.internalId = internalId;
    }

    
    void setInternalId()
    {
        UUID uuid = UUID.randomUUID();
        this.internalId = uuid.toString();
    }

    
    public String getDescription()
    {
        return this.description;
    }

    
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public char[] getPassword()
    {
        return this.password;
    }

    
    public void setPassword(char[] password)
    {
        this.password = password;
    }

    public char[] getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(char[] newPassword)
    {
        this.newPassword = newPassword;
    }

    
    public String getCn()
    {
        return this.cn;
    }

    
    public void setCn(String cn)
    {
        this.cn = cn;
    }

    
    public String getSn()
    {
        return this.sn;
    }

    
    public void setSn(String sn)
    {
        this.sn = sn;
    }

    
    public String getDn()
    {
        return this.dn;
    }

    
    void setDn(String dn)
    {
        this.dn = dn;
    }

    
    public String getOu()
    {
        return this.ou;
    }

    
    public void setOu(String ou)
    {
        this.ou = ou;
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

    
    public boolean isReset()
    {
        return reset;
    }

    
    public void setReset(boolean reset)
    {
        this.reset = reset;
    }

    
    public boolean isLocked()
    {
        return locked;
    }

    
    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    
    public Props getProps()
    {
        return props;
    }

    
    public void setProps(Props value)
    {
        this.props = value;
    }

    
    public void addProperty(String key, String value)
    {
        Props.Entry entry = new Props.Entry();
        entry.setKey(key);
        entry.setValue(value);
        this.props.getEntry().add(entry);
    }

    
    public String getProperty(String key)
    {
        List<Props.Entry> props = this.props.getEntry();
        Props.Entry keyObj = new Props.Entry();
        keyObj.setKey(key);

        String value = null;
        int indx = props.indexOf(keyObj);
        if(indx != -1)
        {
            Props.Entry entry = props.get(props.indexOf(keyObj));
            value = entry.getValue();
        }

        return value;
    }

    
    public void addProperties(Properties props)
    {
        if(props != null)
        {
            for (Enumeration e = props.propertyNames(); e.hasMoreElements(); )
            {

                String key = (String) e.nextElement();
                String val = props.getProperty(key);
                addProperty(key, val);
            }
        }
    }

    
    public Properties getProperties()
    {
        Properties properties = null;
        List<Props.Entry> props = this.props.getEntry();
        if (props.size() > 0)
        {
            properties = new Properties();

            for (Props.Entry entry : props)
            {
                String key = entry.getKey();
                String val = entry.getValue();
                properties.setProperty(key, val);
            }
        }
        return properties;
    }

    
    public Address getAddress()
    {
        if(address == null)
        {
            address = new Address();
        }
        return address;
    }

    
    public void setAddress(Address address)
    {
        this.address = address;
    }

    
    public List<String> getPhones()
    {
        if (phones == null)
        {
            phones = new ArrayList<>();
        }
        return phones;
    }

    
    public void setPhones(List<String> phones)
    {
        this.phones = phones;
    }

    
    public void setPhone(String phone)
    {
        if (phones == null)
        {
            phones = new ArrayList<>();
        }
        this.phones.add(phone);
    }

    
    public List<String> getMobiles()
    {
        if (mobiles == null)
        {
            mobiles = new ArrayList<>();
        }
        return mobiles;
    }

    
    public void setMobiles(List<String> mobiles)
    {
        this.mobiles = mobiles;
    }

    
    public void setMobile(String mobile)
    {
        if (mobiles == null)
        {
            mobiles = new ArrayList<>();
        }
        this.mobiles.add(mobile);
    }

    
    public List<String> getEmails()
    {
        if (emails == null)
        {
            emails = new ArrayList<>();
        }
        return emails;
    }

    
    public void setEmails(List<String> emails)
    {
        this.emails = emails;
    }

    
    public void setEmail(String email)
    {
        if (emails == null)
        {
            emails = new ArrayList<>();
        }
        this.emails.add(email);
    }

    public Boolean isSystem()
    {
        return system;
    }

    public void setSystem(Boolean system)
    {
        this.system = system;
    }

    
    public int hashCode()
    {
        return this.getUserId().toUpperCase().hashCode();
    }

    
    public boolean equals(Object thatObj)
    {
        if (this == thatObj) return true;
        if (this.getUserId() == null) return false;
        if (!(thatObj instanceof User)) return false;
        User thatUser = (User) thatObj;
        if (thatUser.getUserId() == null) return false;
        return thatUser.getUserId().equalsIgnoreCase(this.getUserId());
    }
}
