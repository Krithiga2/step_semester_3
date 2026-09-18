class LibraryMember{
    String memberId;
    int borrowLimit,booksBorrowed;
    LibraryMember(String memberId,int borrowLimit){
        this.memberId=memberId;
        this.borrowLimit=borrowLimit;
    }
    String displayInfo(){
        return "General | Books: "+booksBorrowed;
    }
}
class StudentMember extends LibraryMember{
    String course;
    StudentMember(String memberId,int borrowLimit,String course){
        super(memberId,borrowLimit);
        this.course=course;
    }
    @Override
    String displayInfo(){
        return "Student | Course: "+course+" | Books: "+booksBorrowed;
    }
}
public class WeeklyCirc{
    static String batchPrint(LibraryMember[] members){
        StringBuilder sb=new StringBuilder();
        for(LibraryMember m:members){
            sb.append(m.displayInfo());
            if(m instanceof StudentMember){
                StudentMember s=(StudentMember)m;
                sb.append(" [Course via downcast: "+s.course+"]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        LibraryMember[] members={new LibraryMember("LB5",3),new StudentMember("STU6",3,"ECE")};
        System.out.println(batchPrint(members));
    }
}
