package Commands;
public  class Help {
    static String text = Add.description + "\n" + Average_of_distance.description + "\n" +
            Clear.description  + "\n" + Execute_script.description + "\n" + Exit.description + "\n" +
            History.description + "\n" + Info.description + "\n" + Max_by_distance.description + "\n" +
            Print_field_descending_distance.description + "\n" + Remove_by_id.description + "\n" + Reorder.description + "\n" +
            Save.description + "\n" + Show.description + "\n" + Sort.description + "\n" + Update.description;
    public static  void help() {
        System.out.println(text);
    }
}
