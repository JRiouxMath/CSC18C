/**
 *
 * @author paulconrad
 */

package bags;
        
public class Person implements Comparable {
    private String first_name;
    private String last_name;
    
    
    Person()
    {
        first_name="";
        last_name="";
    }
    
    Person(String fname, String lname)
    {
        this.setFirstName(fname);
        this.setLastName(lname);
    }
    
    public void setFirstName(String first)
    {
        this.first_name=first;
    }
    
    public void setLastName(String last)
    {
        this.last_name=last;
    }
    
    public String getFirstName()
    {
        return this.first_name;
    }
    
    public String getLastName()
    {
        return this.last_name;
    }
    
    // overloaded compareTo
    public int compareTo(Object b)
    {
        Person pb = (Person)b;
        // ret holds return value of compareTo
        int ret=this.getLastName().compareTo(pb.getLastName());
        
        // in the case both Person objects have same lastname
        // so we will be also comparing the firstname
        if (ret==0)
        {
            ret=this.getFirstName().compareTo(pb.getFirstName());
        }
        
        return ret;
    }
    
    @Override
    public String toString()
    {
        return this.getLastName()+", "+this.getFirstName();
    }
}