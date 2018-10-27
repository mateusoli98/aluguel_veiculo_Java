package model;

public class Avaliacao {

    private String comentario;
    private int codigo, numAvaliacao, status;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumAvaliacao() {
        return numAvaliacao;
    }

    public void setNumAvaliacao(int numAvaliacao) {
        this.numAvaliacao = numAvaliacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
