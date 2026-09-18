class LibraryMember{
    String memberId;
    int borrowLimit,booksBorrowed;
    LibraryMember(String memberId,int borrowLimit){
        if(memberId==null||memberId.trim().length()<4) 
            throw new IllegalArgumentException();
        this.memberId=memberId;
        this.borrowLimit=borrowLimit;
    }
    void borrowBook(){
        if(booksBorrowed<borrowLimit) 
            booksBorrowed++;
    }
    int getBooksBorrowed(){
        return booksBorrowed;
    }
    String displayInfo(){
        return "General Member | Books Borrowed: "+booksBorrowed;
    }
}
class StudentMember extends LibraryMember{
    String course;
    StudentMember(String memberId,int borrowLimit,String course){
        super(memberId,borrowLimit);
        this.course=course;
    }
    String displayInfo(){
        return "Student Member | Course: "+course+" | Books Borrowed: "+booksBorrowed;
    }
}
class HonorsStudentMember extends StudentMember{
    int bonusLimit;
    HonorsStudentMember(String memberId,int borrowLimit,String course,int bonusLimit){
        super(memberId,borrowLimit,course);
        this.bonusLimit=bonusLimit;
    }
    String displayInfo(){
        return "Honors Student Member | Course: "+course+" | Bonus Limit: "+bonusLimit+" | Books Borrowed: "+booksBorrowed;
    }
}
class FacultyMember extends LibraryMember{
    String department;
    FacultyMember(String memberId,int borrowLimit,String department){
        super(memberId,borrowLimit);
        this.department=department;
    }
    String displayInfo(){
        return "Faculty Member | Department: "+department+" | Books Borrowed: "+booksBorrowed;
    }
}
public class ThreeBranch{
    static String classifyGeneration(LibraryMember m){
        if(m instanceof HonorsStudentMember) 
            return "Multilevel descendant (3 generations deep)";
        if(m instanceof FacultyMember) 
            return "Hierarchical sibling (independent branch)";
        return "Other";
    }
    static int getTotalBooksBorrowed(LibraryMember[] members){
        int total=0;
        for(LibraryMember m:members) 
            total+=m.getBooksBorrowed();
        return total;
    }
    public static void main(String[] args){
        StudentMember s=new StudentMember("STU2",3,"CSE");
        HonorsStudentMember h=new HonorsStudentMember("STU3",3,"ECE",2);
        FacultyMember f=new FacultyMember("STU4",5,"Physics");
        s.borrowBook();s.borrowBook();h.borrowBook();
        f.borrowBook();f.borrowBook();f.borrowBook();
        System.out.println(s.displayInfo());
        System.out.println(h.displayInfo());
        System.out.println(f.displayInfo());
        System.out.println(classifyGeneration(h));
        System.out.println(classifyGeneration(f));
        LibraryMember[] members={s,h,f};
        System.out.println(getTotalBooksBorrowed(members));
    }
}
