#include <iostream>
#include <stdio.h>
#include <winsock2.h>
#include <ws2tcpip.h>

int main() {

    //------------------------
    int i=0;
    int ID[6];
    FILE *f1;
    f1 = fopen("C:/Users/User/Desktop/Sion.txt","w");
    SetConsoleOutputCP(CP_UTF8);
    HANDLE  hConsole;
    hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    int k=2;
    SetConsoleTextAttribute(hConsole, k);
    //------------------------


    //uvodne nastavovacky

    WSADATA wsaData;    //WSADATA winsock
    int iResult;

// Initialize Winsock
    iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);     //inicializacia
    if (iResult != 0)     //mozna chyba, kontrola
    {
        printf("WSAStartup failed: %d\n", iResult);
        return 1;
    }

    struct addrinfo *result = NULL, *ptr = NULL;     //praca s adresami
    struct addrinfo hints;

    ZeroMemory(&hints, sizeof(hints));
    hints.ai_family = AF_UNSPEC;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = IPPROTO_TCP;     //TCP/IP protokol

// Resolve the server address and port
    iResult = getaddrinfo("147.175.115.34", "777", &hints, &result);
    if (iResult != 0)     //kontrola, ci nenastala chyba
    {
        printf("getaddrinfo failed: %d\n", iResult);
        WSACleanup();
        return 1;
    }
    else
        printf("getaddrinfo didn’t fail…\n");

    //-----------------------------------------
    //-----------------------------------------
    //-----------------------------------------


    SOCKET ConnectSocket = INVALID_SOCKET;


    ptr = result;


    ConnectSocket = socket(ptr->ai_family, ptr->ai_socktype,ptr->ai_protocol);

    if (ConnectSocket == INVALID_SOCKET)     //mozna chyba, treba spravit kontrolu
    {
        printf("Error at socket(): %ld\n", WSAGetLastError());
        freeaddrinfo(result);
        WSACleanup();
        return 1;
    }
    else
        printf("Error at socket DIDN’T occur…\n");


    iResult = connect(ConnectSocket, ptr->ai_addr, (int)ptr->ai_addrlen);
    if (iResult == SOCKET_ERROR)     //kontrola, ci nenastala chyba
        printf("Not connected to server…\n");
    else
    printf("Connected to server!\n");  ////--------------------------PRIPOJENIE NA SERVER

    if (iResult == SOCKET_ERROR)    //osetrenie chyby
    {
        closesocket(ConnectSocket);
        ConnectSocket = INVALID_SOCKET;
        WSACleanup();
        return 1;
    }

    Sleep(250);

    //-----------------------------------------
    //-----------------------------------------
    //-----------------------------------------

    //posielanie

    while (TRUE){

        int zvysok;
        char sendbuf[4096];

        int size = 1024;
        fgets(sendbuf, size, stdin);
        fputs("MOJA SPRAVA: ", f1);
        fputs(sendbuf,f1);

    iResult = send(ConnectSocket, sendbuf, (int)strlen(sendbuf), 0);
    if (iResult == SOCKET_ERROR)
    {
        printf("send failed: %d\n", WSAGetLastError());
        closesocket(ConnectSocket);
        WSACleanup();
        return 1;
    }

    printf("Bytes Sent: %ld\n", iResult);     //vypisanie poctu odoslanych dat

    //-----------------------------------------
    //-----------------------------------------
    //-----------------------------------------

    //prijimanie

#define DEFAULT_BUFLEN 4096


    int recvbuflen = DEFAULT_BUFLEN;
    char recvbuf[DEFAULT_BUFLEN];

    iResult = recv(ConnectSocket, recvbuf, recvbuflen, 0);     //funkcia na príjimanie


    if ( iResult > 0 )
        printf("Bytes received: %d\n", iResult);     //prisli validne data, vypis poctu
    else if ( iResult == 0 )
        printf("Connection closed\n");     //v tomto pripade server ukoncil komunikaciu
    else
    printf("recv failed with error: %d\n", WSAGetLastError());     //ina chyba

    //-----------------------------------------
    //-----------------------------------------
    //-----------------------------------------

    //zavretie socketu

        if (iResult==132){
            while (i<iResult)
            {
                recvbuf[i] = recvbuf[i] ^ 55;
                i++;
            }
        }

        //todo------------------------------------------------------------------------
        fputs("MORPHEUS: ", f1);
        fputs(recvbuf,f1);
        printf("%s\n", recvbuf);

        if (iResult==23){
            printf("\n"); ////------------------------------PRIMENUMBER
            i=1;
            int number;
            int cyklus;
            int prime;
            printf("SECRET CODE: ");
            while (i<iResult)
            {
                number=i;
                prime=1;

                for(cyklus = 2; cyklus < number; cyklus++) {
                    if((i % cyklus) == 0) {
                        prime = 0;
                    }
                }
                if (prime == 1 && number!=1)
                    printf("%c", recvbuf[i-1]);
                i++;
            }
            printf("\n");
        }
        char *uloha;
        int l1;
        int j=0;
        if (iResult==62){
            l1=strtol(sendbuf,&uloha,10); ////----------------------vypocet z ID
            while (l1>0){
                int prime = l1 % 10;  //poslednu cislicu oddeli
                ID[j]=prime; //prida ju do pola
                l1 = l1 / 10;
                j++;
            }
        }
        if (iResult==303){
            if (ID[1]==0)
                ID[1]=9;
            zvysok=(ID[5]+ID[4]+ID[3]+ID[2]+ID[1])%ID[1];
            printf("Zvyšok je: %d\n",zvysok);
        }
        if (iResult==711){
            char KOD[8]="OBVMHKR"; ////----------------------------------BONUS
            for (int final=0;final<strlen(KOD);final++){
                if(KOD[final]+7>90){
                    KOD[final]=KOD[final]-90+64;
                }
                KOD[final]=KOD[final]+7;
            }
            printf("FINAL MESSAGE IS: %s",KOD);
            fputs("FINAL MESSAGE IS: ",f1);
            fputs(KOD,f1);
            return 0;
        }

    }
    fclose(f1);
    closesocket(ConnectSocket);
    WSACleanup();
}

//#pragma comment(lib, "Ws2_32.lib")
//send(ConnectSocket, sendbuf, (int)strlen(sendbuf), 0);