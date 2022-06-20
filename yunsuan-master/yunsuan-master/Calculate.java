import java.util.Random;


public class Calculate {

    public static void main(String[] args) {

        // 运算符
        char[] ch = new char[50];
        //num first secend  result Answer
        int[] numF = new int[50];
        int[] numS = new int[50];
        int[] numR = new int[50];
        int[] numA = new int[50];
        Random random = new Random(1);
        Random rnd2 = new Random(2);
        Random rnd3 = new Random(3);

        for (int i = 0; i < 50; i++) {
            //用num生成运算类型
            int num = random.nextInt(4);
            //numF numS 分别为第一、二个运算数
            numF[i] = rnd2.nextInt(51);
            //在生成题目时 考虑除数不为0
            numS[i] = rnd3.nextInt(51);
            switch (num) {
                case 0:
                    ch[i] = '+';
                    break;
                case 1:
                    ch[i] = '-';
                    break;
                case 2:
                    ch[i] = '*';
                    break;
                case 3:
                    ch[i] = '÷';
                    break;

                default:
                    break;
            }

        }
        // 组合+— *

        for (int i = 0; i < 50; i++) {
            switch (ch[i]) {
                case '+':
                    numR[i] = numF[i] + numS[i];
                    break;
                case '÷':
                    while (numS[i] == 0) {
                        numS[i] = new Random().nextInt(51);
                    }
                    numR[i] = numF[i] / numS[i];
                    break;
                case '*':
                    numR[i] = numF[i] * numS[i];
                    break;
                case '-':
                    numR[i] = numF[i] - numS[i];
                    break;

                default:
                    break;
            }
        }
        //题目数组
        String[] question = new String[50];
        for (int i = 0; i < numR.length; i++) {
            //随机抽取一个运算数用空格替代，存入答案numA数组中
            int flag = random.nextInt(3);

            switch (flag) {
                case 0:
                    question[i] = "___ " + ch[i] + numS[i] + "\t= " + numR[i];
                    numA[i] = numF[i];
                    break;
                case 1:
                    question[i] = numF[i] + " " + ch[i] + " ___" + "= " + numR[i];
                    numA[i] = numS[i];
                    break;
                case 2:
                    question[i] = numF[i] + " " + ch[i] + numS[i] + "\t= " + "___";
                    numA[i] = numR[i];
                    break;

                default:
                    break;
            }
        }
        for (int i = 0; i < 50; i++) {
            System.out.print(question[i]);
            System.out.println("\tAnswer = " + numA[i]);
        }
    }
}
