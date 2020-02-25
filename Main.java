import java.util.Arrays;
public class Main {

    // Encryption
    public void Encryption(String key, String plainText)
    {
        int x=0,y=0;
        String plainTextLower = plainText.replaceAll("\\s","").toLowerCase();
        char[][] temp = new char[key.length()][plainTextLower.length()];

        // write the plaintext into matrix
        for(int i=0;i<plainTextLower.length();i++)
        {
            temp[x][y]=plainTextLower.charAt(i);
            if(x==(key.length()-1))
            {
                x=0;
                y++;
            }
            else
            {
                x++;
            }
        }
        System.out.println("Key is: "+ key);
        System.out.println("Show the plaintext matrix:");
        // show the matrix
        for(int j=0;j<=y;j++)
        {
            for(int i=0;i<key.length();i++)
            {
                if(temp[i][j]=='\0')
                {
                    System.out.print('X');
                    continue;
                }
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }
        // sort the array
        char[] keyArray = key.toCharArray();
        Arrays.sort(keyArray);
        System.out.println("Show the cipher Text: ");
        // encrypt and print them in order
        char[][] newMatrix = new char[key.length()][y+1];

        for(int i=0;i<key.length();i++)
        {
                int pos;
                for(pos =0;pos<keyArray.length;pos++)
                {
                    if(key.charAt(i)==keyArray[pos])
                    {
                        break;
                    }
                }
                for(int j=0;j<=y;j++)
                {
                    newMatrix[pos][j] = temp[i][j];
                }
        }
        //show new matrix in line
        for(int j=0;j<key.length();j++)
        {
            for(int i=0;i<=y;i++)
            {
                if(newMatrix[j][i]=='\0')
                {
                    System.out.print('X');
                    continue;
                }
                System.out.print(newMatrix[j][i]);
            }
        }

    }

    // Decryption
    public void Decryption(String key,StringBuilder cipherText)
    {
        // calculate number of row
        int x = key.length();
        int y = cipherText.length();
        int row;
        if((y%x)!=0&& y!=0 && x!=0)
        {
            row = y/x+1;
        }
        else
        {
            row = y/x;
        }
        System.out.println("Key is: "+ key);
        System.out.println("Show the CipherText: "+ cipherText);
        // sort key array
        char[] keyArray = key.toCharArray();
        Arrays.sort(keyArray);
        //insert cipherText into matrix
        char[][] temp = new char[x][row];
            int pos;
            for(pos=0;pos<keyArray.length;pos++)
            {
               int i,j;
                for(i=0;i<x;i++)
                {
                    if(keyArray[pos]==key.charAt(i))
                    {
                        break;
                    }
                }
                for(j=0;j<row;j++)
                {
                    temp[i][j]=cipherText.charAt(0);
                    cipherText.deleteCharAt(0);
                }
            }


        // show new matrix
        System.out.println("The PlainText is: ");
        for(int j=0;j<row;j++)
        {
            for(int i=0;i<key.length();i++)
            {
//                if(temp[i][j]=='\0')
//                {
//                    System.out.print('X');
//                    continue;
//                }
                System.out.print(temp[i][j]);
            }
        }



    }

// main function
public static void main(String[] args) {
    Main a = new Main();
    // a.Encryption("NYITV", "CRYPTOLOGY IS THE PRACTICE AND STUDY OF TECHNIQUES FOR SECURE COMMUNICATION IN THE PRESENCE OF THIRD PARTIES CALLED ADVERSARIES");
    StringBuilder ss = new StringBuilder("eroohalpsmeptroohalsefxphtnlefhhxtwstiiiieoecrastitosplmgeasentmitrasnefylypnhiasnetoiroitaetaxoeetonicrasetltesnicrfwmurnhrrhitrcrxhtpipsrmaimiitpiphlaleiucciptotpe");
    a.Decryption("NYITV",ss);
    }
}

