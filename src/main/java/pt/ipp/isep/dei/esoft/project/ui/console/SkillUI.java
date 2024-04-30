package pt.ipp.isep.dei.esoft.project.ui.console;

public class SkillUI implements Runnable {
    private String title;
    public SkillUI(String title) {
        this.title = title;
    }
    public void run(){
        System.out.println(title);
    }
}
