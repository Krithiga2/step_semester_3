class LibraryMember{
    protected int borrowLimit;
    protected int booksBorrowed;
    private static int membersEnrolled;
    protected final String memberNumber;
    public LibraryMember(int borrowLimit){
        if(borrowLimit<=0) 
            throw new IllegalArgumentException("Invalid borrow limit");
        membersEnrolled++;
        memberNumber="LIB-"+(100+membersEnrolled);
    }
    public LibraryMember(String memberId,int borrowLimit){
        if(memberId==null||memberId.trim().length()<4) 
            throw new IllegalArgumentException("Invalid member ID");
        if(borrowLimit<=0) 
            throw new IllegalArgumentException("Invalid borrow limit");
        this.borrowLimit=borrowLimit;
        membersEnrolled++;
        memberNumber="LIB-"+(100+membersEnrolled);
    }
    public void borrowBook(){
        if(booksBorrowed<borrowLimit) 
            booksBorrowed++;
    }
    public void borrowBook(String genre){
        borrowBook();
    }
    public int getBooksBorrowed(){
        return booksBorrowed;
    }
    public static boolean isValidRenewalCode(String code){
        if(code==null||code.length()!=4) 
            return false;
        return code.charAt(0)=='R'&&Character.isDigit(code.charAt(1))&&Character.isDigit(code.charAt(2))&&Character.isUpperCase(code.charAt(3));
    }
    public static int getMembersEnrolled(){
        return membersEnrolled;
    }
}
class FacultyMember extends LibraryMember{
    private String department;
    public FacultyMember(int borrowLimit,String department){
        super(borrowLimit);
        this.department=department;
    }
}
public class Renewable{
    static String processNightlyAudit(LibraryMember[] members){
        int processed=0,nullSkipped=0,faculty=0,regular=0;
        for(LibraryMember member:members){
            if(member==null){
                nullSkipped++;
                continue;
            }
            processed++;
            if(member instanceof FacultyMember) 
                faculty++;
            else 
                regular++;
        }
        return processed+" processed | "+nullSkipped+" null skipped | "+faculty+" faculty | "+regular+" regular";
    }
    public static void main(String[] args){
        LibraryMember m1=new LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());
        System.out.println(LibraryMember.isValidRenewalCode("R12A"));
        System.out.println(LibraryMember.isValidRenewalCode("R1A"));
        System.out.println(LibraryMember.isValidRenewalCode("X12A"));
        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());
        System.out.println(processNightlyAudit(new LibraryMember[]{new FacultyMember(5,"Physics"),null,new LibraryMember(3)}));
    }
}
