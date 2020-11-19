public class Tree {
    public static void tree(int n, double x, double y, double a, double branchRadius) {
        double bendAngle   = Math.toRadians(ramdom());
        double branchAngle = Math.toRadians(ramdom());
        double branchRatio = .65;

        double cx = x + Math.cos(a) * branchRadius ;
        double cy = y + Math.sin(a) * branchRadius ;
        StdDraw.setPenRadius(.001 * Math.pow(n, 1.2));

        /** 
        Ramdom de entre 1 y 2 para elejir el color a pintar para la rama
        si el numero ramdom es 2 pintara de color verde sino rojo, semejando 
        flores de  2 colores
         */
        int numero = (int) (Math.random() * 2) + 1;
        if( n < 1){
            if(numero>1)
                StdDraw.setPenColor(StdDraw.GREEN);
            else
            // rojo para aparentar manzanas :)
                StdDraw.setPenColor(StdDraw.RED);
        }

        else { StdDraw.setPenColor(StdDraw.BLACK);}

        StdDraw.line(x, y, cx, cy);
        if (n == 0 ) return;
        tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);
        tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);
        tree(n-1, cx, cy, a + bendAngle,               branchRadius * (1 - branchRatio));
        tree(n-1, cx, cy, a + bendAngle + 17.05 + branchAngle , branchRadius * branchRatio);

    } 

    /** Retorna un angulo aleaotorio para el arbol */
    static  int  ramdom(){
        int rdn =(int) (Math.random() * 4) + 0;
        int aux [] = {15,37,20,30,140};

        return aux[rdn];
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.show(0);
        tree(N, .5, 0, Math.PI/2, .3);
        StdDraw.show(0);
    }
}
