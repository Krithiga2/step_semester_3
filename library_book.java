class librarybook{
    String title;
    String isbn;
    public librarybook(String title,String isbn){
        this.title=title;
        this.isbn=isbn; 
    }
    public librarybook(String title){
        this(title,"PENDING");
    }
    void display(){
        System.out.println(title+"|"+isbn+"|catalogue=true");
    }
}
class library_book{
    public static void main(String[] args) {
        String[] titles={"clean code","untitled draft","1984","notes"};
        String[] isbns={"978-032350884","","9788451524935",""};
        librarybook book;
        for (int i=0;i<titles.length;i++){
            if (isbns[i].equals(""))
                book=new librarybook(titles[i]);
            else
                book= new librarybook(titles[i],isbns[i]);
            book.display();
        }
    }
        

};