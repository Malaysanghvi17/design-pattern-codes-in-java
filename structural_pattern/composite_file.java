import java.util.ArrayList;
import java.util.List;
abstract class Folder {
    protected String name;
    public Folder(String name) {
        this.name = name;
    }
    public abstract void showName();
    public abstract int getSize();
    public abstract void showFileType();
}
class File extends Folder {
    private String fileType;
    private int size;
    public File(String name,String fileType,int size) {
        super(name);
        this.fileType = fileType;
        this.size = size;
    }
    @Override
    public void showName() {
        System.out.println("StructuralDesignPattern.File: "+name);
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void showFileType() {
        System.out.println("StructuralDesignPattern.File Type: "+fileType);
    }
}
class Directory extends Folder {
    private int totalSize;
    public Directory(String name) {
        super(name);
    }
    private List<Folder> ls = new ArrayList<>();
    @Override
    public void showName() {
        System.out.println("StructuralDesignPattern.Composite : " + name);
        for(Folder c : ls){
            c.showName();
        }
    }
    @Override
    public int getSize() {
        for(Folder f:ls) {
            totalSize += f.getSize();
        }
        return totalSize;
    }
    @Override
    public void showFileType() {
        for(Folder c : ls){
            c.showFileType();
        }
    }
    public void addFolder(Folder c)
    {
        ls.add(c);
    }
    public void removeFolder(Folder c)
    {
        ls.remove(c);
    }
    public List getFolders(){
        return ls;
    }
}
public class composite_file {
    public static void main(String[] args) {
        Folder f1 = new File("ABC.txt","Text.File",2);
        Folder f2 = new File("XYZ.docx","Word.File",20);
        Folder f3 = new File("DEF.pptx","Powerpoint Presentation",100);
        Directory d1 = new Directory("123");
        Directory d2 = new Directory("456");

        d1.addFolder(f1);
        d1.addFolder(f2);
        d2.addFolder(f1);
        d2.addFolder(f2);
        d2.addFolder(f3);
        System.out.println(d1.getSize());
        System.out.println(d2.getSize());
        d1.showName();
        d2.showName();
    }
}