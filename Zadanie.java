import java.util.*;
import java.lang.*;
import java.io.*;

interface Cabinet
{
    // zwraca dowolny element o podanej nazwie
    Optional<Folder> findFolderByName(String name);

    // zwraca wszystkie foldery podanego rozmiaru SMALL/MEDIUM/LARGE
    List<Folder> findFoldersBySize(String size);

    //zwraca liczbę wszystkich obiektów tworzących strukturę
    int count();
}

public class FileCabinet implements Cabinet
{
    private List<Folder> folders;
    FileCabinet(List<Folder> multiFolders)
    {
        this.folders = multiFolders;
    }
    @Override
    public Optional<Folder> findFolderByName(String name)
    {
        return Optional.ofNullable(this.folders)
                .flatMap(l -> l.stream()
                        .filter(s -> Objects.equals(s.getName(), name))
                        .findFirst());
    }
    @Override
    public List<Folder> findFoldersBySize(String size)
    {
        return this.folders.stream().filter(folder -> Objects.equals(folder.getSize(), size)).toList();
    }
    @Override
    public int count()
    {
        return this.folders.size();
    }
}

interface Folder
{
    String getName();
    String getSize();

}

interface MultiFolder extends Folder
{
    List<Folder> getFolders();
}
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
}
