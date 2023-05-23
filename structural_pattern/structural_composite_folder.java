//
//import java.util.ArrayList;
//import java.util.List;
//
//abstract class File{
//    protected String name;
//    protected int size;
//
//    public File(String n,int p){
//        name = n;
//        size = p;
//    }
//
//    public File(String n){
//        name = n;
//
//    }
//
//    public abstract void showDetail();
//    public abstract int getSize();
//}
//
//class leaf extends File{
//    public leaf(String n,int p){
//        super(n,p);
//    }
//
//    public void showDetail(){
//        System.out.println("File Name : \t" + name + ", \tSize : " + size);
//    }
//
//    public int getSize() {
//        return size;
//    }
//}
//
//class Folder extends File{
//    private List<File> fl = new ArrayList<File>();
//    int TSize=0;
//    public Folder(String n){
//        super(n);
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void addFile(File f){
//        fl.add(f);
//    }
//
//    public void RemoveFile(File f){
//        fl.remove(f);
//    }
//
//
//    public void showDetail(){
//        for(File f : fl){
//            TSize=TSize+f.getSize();
//        }
//
//        System.out.println("Folder Name : \t" + name + ", \tSize : " + TSize);
//        System.out.println("File List :");
//        for(File f : fl){
//            f.showDetail();
//        }
//        System.out.println();
//    }
//
//}
//
//
//public class structural_composite_folder {
//    public static void main(String[] args) {
//        File f1 = new leaf("ABC", 10);
//        File f2 = new leaf("DEF", 20);
//        File f3 = new leaf("GHI", 30);
//        File f4 = new leaf("JKL", 40);
//        File f5 = new leaf("MNO", 50);
//
//        Folder Fold1 = new Folder("Folder1");
//        Folder Fold2 = new Folder("Folder2");
//        Folder Fold3 = new Folder("Folder3");
//
//        Fold1.addFile(f1);
//        Fold1.addFile(f2);
//        Fold1.addFile(f3);
//
//        Fold2.addFile(f3);
//        Fold2.addFile(f4);
//        Fold2.addFile(f5);
//
//        Fold3.addFile(f5);
//        Fold3.addFile(f1);
//        Fold3.addFile(f3);
//
//        Fold1.showDetail();
//        Fold2.showDetail();
//        Fold3.showDetail();
//    }
//}

//import java.util.ArrayList;
//import java.util.List;
//
//// leaf -- file
//// Composite -- directory
//
//abstract class Directory
//{
//    protected String name;
//    protected int size;
//    protected String type;
//
//    public Directory(String n, int size)
//    {
//        name = n;
//        this.size=size;
//    }
//
//    public Directory(String n, int size, String type)
//    {
//        name=n;
//        this.size=size;
//        this.type=type;
//    }
//
//    public abstract void showname();
//    public abstract void getSize();
//    public abstract void getType();
//}
//
//class Files extends Directory
//{
//    private int file_size;
//    private String file_name;
//    private String file_type;
//
//    public Files(String file_name, int file_size)
//    {
//        super(file_name,file_size);
//        file_type = null;
//    }
//
//    public Files(String file_name, int file_size, String file_type)
//    {
//        super(file_name,file_size,file_type);
//    }
//
//    @Override
//    public void showname()
//    {
//        System.out.println("Name of the file is : " + file_name);
//    }
//
//    @Override
//    public void getSize()
//    {
//        System.out.println("Size of the file is : " + file_size);
//
//    }
//
//    @Override
//    public void getType()
//    {
//        System.out.println("The type of file is : " + file_type);
//    }
//
//}
//
//class Folders extends Directory
//{
//    private List<Directory> list = new ArrayList<Directory>();
//
//
//    public Folders(String name,int size)
//    {
//        super(name,size);
//    }
//
//    public void showname()
//    {
//        System.out.println("Folders name : " + name);
//
//        for(Directory d : list)
//        {
//            d.showname();
//        }
//    }
//
//    public void addFolder(Directory d)
//    {
//        list.add(d);
//    }
//
//    public void deleteFolder(Directory d)
//    {
//        list.remove(d);
//    }
//
//    public List displayDirectory()
//    {
//        return list;
//    }
//
//    int total_size;
//
//    @Override
//    public void getSize()
//    {
//        for(Directory d : list)
//        {
//            total_size = size + total_size;
//        }
//
//        System.out.println("Size is : " + total_size);
//    }
//
//    @Override
//    public void getType()
//    {
//        System.out.println("This is a Folder");
//    }
//}
//
//class structural_Composite_folder
//{
//    public static void main(String[] args)
//    {
//        Directory d1 = new Folders("Java", 20);
//        Directory d2 = new Folders("DBMS", 100);
//
//        Directory d3 = new Files("Polymorphism", 100);
//        Directory d4 = new Files("Primary Key",450,".csv");
//
//        d2.showname();
//        d1.getSize();
//
//        d3.getSize();
//        d4.getType();
//        d1.getType();
//    }
//}