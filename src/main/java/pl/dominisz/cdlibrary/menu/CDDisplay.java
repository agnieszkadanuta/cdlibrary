package pl.dominisz.cdlibrary.menu;

import pl.dominisz.cdlibrary.cd.CD;

import java.util.List;

public class CDDisplay {

public static void show(List<CD> list){
    list.forEach(cd-> System.out.println(cd));
}
}
