package task.tasks;

import org.w3c.dom.ranges.Range;
import task.IncorrectArgumentException;

import java.util.Random;
import java.util.Scanner;

public class ScannerService {


    public Integer findException(int minNum, int maxNum) throws IncorrectArgumentException {
        Scanner scanner = new Scanner(System.in);
        int numFromConsole = scanner.nextInt();
        if (numFromConsole < minNum || numFromConsole > maxNum) {
            throw new IncorrectArgumentException("Вы ввели неверный параметр");
        }
        return numFromConsole;
    }

    public Integer defenseFromException(int minNum, int maxNum) throws IncorrectArgumentException {
        int num = 0;
        while (num == 0) {
            try {
                num = this.findException(minNum, maxNum);
            } catch (IncorrectArgumentException e) {
                System.out.println("Кхм пук пук вы ввели невермбное знамчение среньк \nВведите число из предложенных вариантов:");
            }
        }
        return num;
    }

    //public Integer rightNumChose(int minNum, int maxNum) {
    //    int typeNum = 0;
    //    while (typeNum == 0) {
    //        typeNum = this.defenseFromException(minNum,maxNum);
    //    }
    //    return typeNum;
    //}
}
