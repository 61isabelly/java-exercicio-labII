public class Campo {
    private EstadoCampo estado;

    public Campo() {
        this.estado = EstadoCampo.VAZIO;
    }

    public EstadoCampo getEstado() {
        return estado;
    }

    public void setEstado(EstadoCampo estado) {
        this.estado = estado;
    }

    public char getSimbolo() {
        return estado.getSimbolo();
    }
}

