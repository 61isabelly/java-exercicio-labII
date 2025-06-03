public enum EstadoCampo {
    VAZIO(' '),
    JOGADOR1('X'),
    JOGADOR2('O');

    private final char simbolo;

    EstadoCampo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
