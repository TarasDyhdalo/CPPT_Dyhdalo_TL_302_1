package KI302.Dyhdalo.Lab5;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResultIO {

    public void writeText(String fileName, List<ResultRecord> records) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileName, false)))) {

            out.println("timestamp,x,y,status,message");

            for (ResultRecord r : records) {
                // захист від коми в message
                String safeMsg = r.getMessage() == null ? "" : r.getMessage().replace(',', ';');
                out.printf("%s,%.15f,%.15f,%s,%s%n",
                        r.getTimestamp(),
                        r.getX(),
                        r.getY(),
                        r.getStatus(),
                        safeMsg);
            }
        }
    }

    public List<ResultRecord> readText(String fileName) throws IOException {
        List<ResultRecord> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean first = true;
            while ((line = br.readLine()) != null) {
                if (first) { // пропустити заголовок
                    first = false;
                    continue;
                }
                if (line.isEmpty()) continue;

                String[] parts = line.split(",", 5);
                if (parts.length < 5) continue;

                LocalDateTime ts = LocalDateTime.parse(parts[0]);
                double x = Double.parseDouble(parts[1]);
                double y = Double.parseDouble(parts[2]);
                String status = parts[3];
                String message = parts[4];

                list.add(new ResultRecord(ts, x, y, status, message));
            }
        }

        return list;
    }

    public void writeBinary(String fileName, List<ResultRecord> records) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)))) {

            dos.writeInt(records.size());

            for (ResultRecord r : records) {
                writeString(dos, r.getTimestamp().toString());
                dos.writeDouble(r.getX());
                dos.writeDouble(r.getY());
                writeString(dos, r.getStatus());
                writeString(dos, r.getMessage() == null ? "" : r.getMessage());
            }
        }
    }

    public List<ResultRecord> readBinary(String fileName) throws IOException {
        List<ResultRecord> list = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))) {

            int count = dis.readInt();
            for (int i = 0; i < count; i++) {
                String tsStr = readString(dis);
                double x = dis.readDouble();
                double y = dis.readDouble();
                String status = readString(dis);
                String msg = readString(dis);

                LocalDateTime ts = LocalDateTime.parse(tsStr);
                list.add(new ResultRecord(ts, x, y, status, msg));
            }
        }

        return list;
    }

    private void writeString(DataOutputStream dos, String s) throws IOException {
        byte[] bytes = s.getBytes("UTF-8");
        dos.writeInt(bytes.length);
        dos.write(bytes);
    }

    private String readString(DataInputStream dis) throws IOException {
        int len = dis.readInt();
        byte[] bytes = new byte[len];
        dis.readFully(bytes);
        return new String(bytes, "UTF-8");
    }
}
