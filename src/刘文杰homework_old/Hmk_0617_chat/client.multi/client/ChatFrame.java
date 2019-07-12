package 刘文杰homework_old.Hmk_0617_chat.client.multi.client;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {
    static JButton button_2;
    static JTextArea textArea_1;
    static JTextArea textArea;
    public ChatFrame() {
        super();
        setTitle(ClientWindowMain.name+"—聊天窗");
        setBounds(100, 100, 558, 576);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5,5));
        getContentPane().add(panel, BorderLayout.NORTH);

        final JLabel label = new JLabel(new ImageIcon("Images/logo.jpg"));
        panel.add(label, BorderLayout.WEST);
        label.setPreferredSize(new Dimension(74,74));

        final JPanel panel_1 = new JPanel();
        panel_1.setLayout(new BorderLayout());
        panel.add(panel_1, BorderLayout.CENTER);

        final JLabel advancingSwiftLabel = new JLabel();
        advancingSwiftLabel.setText("欢迎"+ ClientWindowMain.name);
        panel_1.add(advancingSwiftLabel, BorderLayout.CENTER);

        final JLabel neverWasteTimeLabel = new JLabel();
        neverWasteTimeLabel.setText("加入本聊天室");
        panel_1.add(neverWasteTimeLabel, BorderLayout.SOUTH);

        final JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(300);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        getContentPane().add(splitPane, BorderLayout.CENTER);

        final JPanel panel_2 = new JPanel();
        panel_2.setLayout(new BorderLayout());
        splitPane.setRightComponent(panel_2);

        final JPanel panel_3 = new JPanel();
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_3.setLayout(flowLayout);
        panel_2.add(panel_3, BorderLayout.NORTH);

        final JButton button = new JButton();
        button.setText("字体");
        panel_3.add(button);

        final JPanel panel_4 = new JPanel();
        final FlowLayout flowLayout_1 = new FlowLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel_4.setLayout(flowLayout_1);
        panel_2.add(panel_4, BorderLayout.SOUTH);

        final JButton button_1 = new JButton();
        button_1.setText("关闭");
        panel_4.add(button_1);

        button_2 = new JButton();
        button_2.setText("发送");
        panel_4.add(button_2);

        final JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane, BorderLayout.CENTER);

        textArea_1 = new JTextArea();
        scrollPane.setViewportView(textArea_1);

        final JScrollPane scrollPane_1 = new JScrollPane();
        splitPane.setLeftComponent(scrollPane_1);

        textArea = new JTextArea();
        scrollPane_1.setViewportView(textArea);
    }

}