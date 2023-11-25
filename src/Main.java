import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;

public class Main extends javax.swing.JFrame {
    User user = new User();
    myDB DBM = new myDB();
    ArrayList<String> ment = new ArrayList<String>();
    int randomCount, randomCount2 = 0;
    
    public void ListNameAdd(){
        for(int i=0;i < ment.size(); i++){
            ment.set(i, ment.get(i).replace("ㅁㅁ",user.getUserName()));
            JOptionPane.showMessageDialog(this, ment.get(i)+ "", "로그인 성공", 1);
        }
    }
    
    public Main(String owner) {
        user.setUserName(owner);
        initComponents();
        NameLabel.setText(user.getUserName()+ "님");
        try {
            DBM.dbOpen();
            String sql_query = String.format("SELECT * FROM text");
            DBM.DB_rs = DBM.DB_stmt.executeQuery(sql_query);
            while(DBM.DB_rs.next()){
                ment.add(DBM.DB_rs.getString(1));
            }
            
            DBM.DB_rs.close();
            DBM.dbClose();
        }catch(Exception e){
            System.out.println("SQL Exception : "+ e.getMessage());
        }
        ListNameAdd();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        jujeobLabel = new javax.swing.JLabel();
        makeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NameLabel.setText("님");

        jujeobLabel.setText("주접 글 생성기");

        makeButton.setText("생성");
        makeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("로그아웃");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(makeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jujeobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(NameLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(NameLabel)
                .addGap(36, 36, 36)
                .addComponent(jujeobLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(makeButton))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Login j = new Login();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void makeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeButtonActionPerformed
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        randomCount = random.nextInt(ment.size());
        
        while(randomCount == randomCount2){
            randomCount = random.nextInt(ment.size());
        }
        jujeobLabel.setText("<HTML><body>"+ment.get(randomCount)+"</body></HTML>");
        randomCount2 = randomCount;
    }//GEN-LAST:event_makeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel jujeobLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton makeButton;
    // End of variables declaration//GEN-END:variables
}
