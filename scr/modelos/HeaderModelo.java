package scr.modelos;
// emoticones: ⚠️🔥📝❎✅📂⚙️🏷️📦📆🗓️🕑🏁➡️⬆️🎁🛒🛍️✏️🖍️✂️🔒🔓💎😀😃
// ✏️🇻🇪📚👍👑🎩🧢🐻‍❄️🐨🌎🌙💥🔥🌏🌍🍔🍟🍕🍩🍪🍿🍸🍹🧉🍾🍺🍻⚽🏀🏈🚗🚕🎲
// ♟️🎯🚌🚎🚨🚍🚘🚖🚀🛟🚢🛩️✈️🚁⌚📱📲💽📟☎️📡⏳🪜⚙️⚖️💎🪚🔩🪪💳🩻🩹🌡️🧹🪠🪒🪥🚰🚿🚽🧻🔑🗝️
public class HeaderModelo {
    private String curso="";
    private String academia="";
    private String proyecto="";
    public String linea="*******************************";
    private String profesor="";
    public String autor="♟\uFE0F Autor: Luis Sánchez. sanchezluys";

    public String getApi() {
        return "https://swapi.dev/api/films/";
    }

    public void setApi(String api) {
        this.api = "\uD83C\uDFAF API: "+ api;
    }

    private String api="";

    public String getProfesor() {
        return "✏\uFE0F Profesor: "+profesor;
    }

    public String getCurso() {
        return "\uD83D\uDCDA Curso: "+ curso;
    }

    public String getAcademia() {
        return "\uD83D\uDC51 Academia: "+academia;
    }

    public String getProyecto() {
        return "\uD83D\uDE80 Proyecto: "+ proyecto;
    }


    /**
     * Colocar el nombre completo del profesor.
     * @param profesor el nombre completo del profesor
     */
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    /**
     * Colocar el nombre completo del curso.
     * @param curso el nombre completo del profesor
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Colocar el nombre completo de la academia.
     * @param academia el nombre completo del profesor
     */
    public void setAcademia(String academia) {
        this.academia = academia;
    }

    /**
     * Colocar el nombre completo del proyecto.
     * @param proyecto el nombre completo del profesor
     */
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public void imprimirEncabezado(){
        System.out.println(this.linea);
        System.out.println(this.getAcademia());
        System.out.println(this.getCurso());
        System.out.println(this.getProfesor());
        System.out.println(this.autor);
        System.out.println(this.getProyecto());
        System.out.println(this.api);
        System.out.println(this.linea);
    }



}
