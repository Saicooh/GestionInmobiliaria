package src.main.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class GeneradorXLSX
{

    public static void main(String[] args) throws IOException
    {
        Workbook workbook = new XSSFWorkbook();  // Crear nuevo libro de trabajo
        Sheet sheet = workbook.createSheet("Edificios"); // Crear nueva hoja

        // Agregar datos de ejemplo
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nombre");
        headerRow.createCell(1).setCellValue("Dirección");
        headerRow.createCell(2).setCellValue("Demanda");

        // Suponiendo que tienes una lista de edificios, puedes iterar sobre ellos y agregarlos a la hoja
        // Por ahora, solo agregaré datos de ejemplo
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue("Edificio A");
        dataRow.createCell(1).setCellValue("Calle 123");
        dataRow.createCell(2).setCellValue(5);

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream("edificios.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
    }
}
