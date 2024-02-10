class GeheimeCode {
    private int[] code = new int[5];

    public GeheimeCode(int[] code) {
        this.code = code;
    }

    public int telJuistePositie(int[] gok) {
        int juistePosities = 0;
        for (int i = 0; i < code.length; i++) {
            if (code[i] == gok[i]) {
                juistePosities++;
            }
        }
        return juistePosities;
    }

    public int telSomJuistePositie(int[] gok) {
        int somJuistePosities = 0;
        for (int i = 0; i < code.length; i++) {
            if (code[i] == gok[i]) {
                somJuistePosities += code[i];
            }
        }
        return somJuistePosities;
    }
}


