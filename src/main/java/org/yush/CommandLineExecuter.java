package org.yush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CommandLineExecuter {

    public void executeCommand(CommandsFfmpeg cmd, String filename, String destinationPath) {
     try {
        // Создание списка аргументов для команды
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Установка рабочего каталога (если нужно)
        // processBuilder.directory(new File("путь/к/каталогу"));

         String comand = String.format(cmd.getComand(),filename,destinationPath);
         processBuilder.command(comand.split(" "));
        // Запуск команды
        Process process = processBuilder.start();
        // Получение вывода команды
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        // Ожидание завершения команды
        int exitCode = process.waitFor();
        System.out.println("Команда завершилась с кодом: " + exitCode);

    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}
}