package src.main.resources;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import src.main.model.Departamento;
import src.main.model.Edificio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public final class GeneradorXLSX
{
    private GeneradorXLSX() {}
    public static void generarArchivoXLSX(ArrayList<Edificio> listaEdificios, String rutaXLSX) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Edificios y Departamentos");

        int rowNum = 0;

        for (Edificio edificio : listaEdificios)
        {
            Row edificioRow = sheet.createRow(rowNum++);

            edificioRow.createCell(0).setCellValue("Nombre del Edificio: " + edificio.getNombre());
            edificioRow.createCell(1).setCellValue("Dirección: " + edificio.getDireccion());
            edificioRow.createCell(2).setCellValue("Demanda: " + edificio.getDemanda());
            edificioRow.createCell(3).setCellValue("Cantidad de Departamentos: " + edificio.getCantidadDepartamentos());

            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Número de Departamento");
            headerRow.createCell(1).setCellValue("Cantidad de Habitaciones");
            headerRow.createCell(2).setCellValue("Tipo de Departamento");
            headerRow.createCell(3).setCellValue("Disponibilidad");

            for (Departamento depto : edificio.getDepartamentos()) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(depto.getNumero());
                dataRow.createCell(1).setCellValue(depto.getCantidadHabitaciones());
                dataRow.createCell(2).setCellValue(depto.getNombreTipo());
                dataRow.createCell(3).setCellValue(depto.getDisponible());
            }
            rowNum++;
        }

        for (int i = 0; i < 4; i++)
            sheet.autoSizeColumn(i);

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream(rutaXLSX)) { workbook.write(fileOut); }
        workbook.close();
    }

}
