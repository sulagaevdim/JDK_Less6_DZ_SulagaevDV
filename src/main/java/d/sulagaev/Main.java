package d.sulagaev;

import java.util.*;
/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла
(Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям
 */

public class Main {
    public static void main(String[] args) {
        int winnerSteps = 0;
        Map<Integer, Boolean> stasistics = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Boolean b = hitTheGift();
            stasistics.put(i, b);
            if (b) winnerSteps++;
        }
        winAndLoser(1000, winnerSteps);
    }

    /*
    метод создает массив из 3 дверей, рандомно одну дверь отмечает "победной",
    далее рандомно удаляется 1 дверь (иммитация выбора "участником" двери)
    далее удаляется 1 дверь "не победная" (якобы ведущий убрал одну непобедную дверь)
    возврат true если участник выбрал вторую дверь и она оказалась "победной",
    либо false если выбрал вторую дверь и она оказалась "не победной"
     */
    public static boolean hitTheGift(){
        List<Boolean> doors = new ArrayList<>(Arrays.asList(false,false,false));
        doors.set((new Random().nextInt(0,3)), true);
        doors.remove(new Random().nextInt(0,3));
        if (!doors.get(0)) doors.remove(0);
        else doors.remove(1);
        if (doors.get(0)) return true;
        return false;
    }
    public static void winAndLoser(int total, int winnerSteps) {
        System.out.printf("Количество выигрышей из %d попыток: %d\n", total, winnerSteps);
        System.out.printf("Количество проигрышей: %d\n", total - winnerSteps);
        System.out.println("Процент открытий двери с подарком: " + ((double) winnerSteps / 10) + "%");
    }
}