package com.tao.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUploadDemo extends JFrame {
    private JButton chooseFileButton;
    private JButton uploadButton;
    private JTextArea textArea;  // 显示文件内容的文本区域

    public FileUploadDemo() {
        setTitle("文件上传示例");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chooseFileButton = new JButton("选择文件");
        uploadButton = new JButton("上传");
        textArea = new JTextArea(10, 30);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    displayFileContent(selectedFile);
                }
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadFileContent();
            }
        });

        setLayout(new FlowLayout());
        add(chooseFileButton);
        add(uploadButton);
        add(new JScrollPane(textArea));  // 将文本区域添加到滚动窗格

        setVisible(true);
    }

    private void displayFileContent(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void uploadFileContent() {
        String fileContent = textArea.getText();
        try {
            URL url = new URL("https://example.com/upload");  // 替换为实际的服务器端上传地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/plain");

            OutputStream os = connection.getOutputStream();
            os.write(fileContent.getBytes());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("文件上传成功！");
            } else {
                System.err.println("文件上传失败，HTTP响应码：" + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileUploadDemo();
            }
        });
    }
}
