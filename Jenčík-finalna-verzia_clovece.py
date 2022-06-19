import random
def nakresli(pole):
    for i in range(len(pole)):
        for j in range(len(pole[i])):
            print(pole[i][j], end=' ') # vykreslenie plochy
        print()
def vytvor(pocet_riadkov, pocet_stlpcov, hodnota=0):
    vysl = []  
    for i in range(pocet_riadkov+1):    #vytvorenie plochy
        vysl.append([' '] * pocet_stlpcov)
    return vysl

n=int(input('Zadaj veľkosť plochy: '))
if n%2==0 or n<5:
    raise Exception("no even numbers or lower than 5 , restart program")
print('Počet panáčikov pre každého hráča: ',(n-3)//2)
matica=vytvor(n,n+1)
matica[0][0]=(' ')
prek=-1 #prekročenie,ak je krajné číslo väčšie ako 9

# vyrobenie počiatočnej plochy:
for i in range(n):
    prek=prek+1
    if prek>9:
        prek=0
    matica[0][i+1]=prek
    matica[i+1][0]=prek
#-------------------------------------
    for j in range(n):
        matica[j+1][((n-1)//2)]='*'         #lavy_stlpec
#-------------------------------------
    for j in range(n):
        matica[j+1][((n+3)//2)]='*'         #pravy_slpec
#-------------------------------------
    for j in range(n):
        matica[j+1][((n+1)//2)]='D'         #stredny_stlpec
#-------------------------------------
    for j in range(n):
        matica[(n+1)//2][j+1]='*'
    for j in range(n-2):
        matica[(n+1)//2][j+2]='D'           #stredny riadok
    for j in range(n-2):
        matica[(n+1)//2][(n+1)//2]='X'
#-------------------------------------
    for j in range(n):
        matica[(n)//2][j+1]='*'
    for j in range(n-2):                    #nad_stredom
        matica[(n)//2][(n+1)//2]='D'
#-------------------------------------
    for j in range(n):
        matica[(n+3)//2][j+1]='*'
    for j in range(n-2):                    #pod_stredom
        matica[(n+3)//2][(n+1)//2]='D'
#-------------------------------------
    for j in range(3):
        matica[1][((n-1)//2)+j]='*'         #najvyšší
#-------------------------------------
    for j in range(3):
        matica[n][((n-1)//2)+j]='*'         #najnižší
#-------------------------------------
cele=[]


for i in range(n+1):
    cele.append(matica[n-n+i]) #vytvorenie pola z matice(spravené, ak by boli chyby v matici)

dlzka_trasy_A=(n-((n+3)/2))*8+8 +((n-3)/2)
dlzka_trasy_B=(n-((n+3)/2))*8+8 +((n-3)/2)
pocet_panacikov_A=(n-3)//2
pocet_panacikov_B=(n-3)//2

PA=0 #počítadlo pre hráča A
PB=0 #počítadlo pre hráča B
x=1 #počiatočné súradnice pre hráča A(neskor je x+1 aby boli počiatočné súradnice správne)
y=n//2+1 #počiatočné súradnice pre hráča A(neskor je y+1 aby boli počiatočné súradnice správne)
q=n-2 #počiatočné súradnice pre hráča B(neskor je q+1 aby boli počiatočné súradnice správne)
w=n//2-1 #počiatočné súradnice pre hráča B(neskor je w+1 aby boli počiatočné súradnice správne)
hA=0 #podmienka, aby program fungoval, keď na pole sa dostane postava po hodení 6(hráč A)
hB=0 #podmienka, aby program fungoval, keď na pole sa dostane postava po hodení 6(hráč B)

#vytvorenie človeče (rôzne písmená pri podmienkach znamenajú jednotlivé časti mapy- v poradí, akom som ich robil
while pocet_panacikov_A!=0 and pocet_panacikov_B!=0:
    hod_A=random.randint(1,6)
    PO=0
    PO_A=0
    #pohyb hráča A
    if PA==0 and hod_A==6:
        cele[1][(n//2)+2]='A'
        print('HRAC A HODIL 6!')
        print()
        nakresli(cele)
        hA=hA+1
    if hA==1:
        hod_A=random.randint(1,6)
        if PA+hod_A>dlzka_trasy_A-1:
            print()
            print('Hráč A hodil: ',hod_A)
            hod_A=0
            print('Neplatný hod hráča A: 0')
            print()
        else:
            print()
            print('Hráč A hodil: ',hod_A)
            print()
        for i in range(hod_A):
            PA=PA+1
            x=x+1
            y=y+1
            PO=PO+1
            PO_A=PO_A+1
            if x<n//2 and y==n//2+2 and PO_A>0:
                cele[x-1][y]='*'
                cele[x][y]='A'#<--A
                y=y-1
                PO_A=0
            if x==n//2 and y<n and y>n//2+1:
                cele[x][y-1]='*'
                if x==n//2 and y==n//2+2:
                    cele[x-1][y]='*'
                    if pocet_panacikov_A==(n-3)//2:
                        cele[x][y-1]='D'
                    if pocet_panacikov_A<(n-3)//2:
                        cele[x][y-1]='A'
                cele[x][y]='A'#<--B
                x=x-1
            if y==n and x<n//2+2 and x>n//2-1:
                cele[x-1][y]='*'
                if x==n//2 and y==n:
                    cele[x][y-1]='*'
                    cele[x-1][y]=''
                cele[x][y]='A'#<--C
                y=y-1
            if x==n//2+2 and y>n//2+2:
                if x==n//2+2 and y==n:
                    cele[x-1][y]='*'
                if x==n//2+2 and y<n:
                    cele[x][y+1]='*'
                cele[x][y]='A'#<--D
                y=y-2
                x=x-1
            if y==n//2+2 and x<n and x>n//2+1:
                if y==n//2+2 and x==n//2+2:
                    cele[x][y+1]='*'
                if x>n//2+2 and y==n//2+2:
                    cele[x-1][y]='*'
                cele[x][y]='A'#<--E
                y=y-1
                PO=0
            if x==n and y>n//2 and PO>0:
                if x==n and y==n//2+2:
                    cele[x-1][y]='*'
                if x==n and y==n//2+1:
                    cele[x][y+1]='*'
                cele[x][y]='A'#<--F
                y=y-2
                x=x-1
                PO=0
            if x>n//2+2 and y==n//2 and PO>0:
                if x==n and y==n//2:
                    cele[x][y+1]='*'
                if x>n//2+2 and x<n and y==n//2:
                    cele[x+1][y]='*'
                cele[x][y]='A'#<--G
                y=y-1
                x=x-2
                PO=0
            if x==n//2+2 and y<n//2+1 and y>1 and PO>0:
                if x==n//2+2 and y==n//2:
                    cele[x+1][y]='*'
                if x==n//2+2 and y<n//2:
                    cele[x][y+1]='*'
                cele[x][y]='A'#<--H
                x=x-1
                y=y-2
                PO=0
            if y==1 and x>n//2 and PO>0:
                if y==1 and x==n//2+2:
                    cele[x][y+1]='*'
                if y==1 and x==n//2+1:
                    cele[x+1][y]='*'
                cele[x][y]='A'#<--I
                y=y-1
                x=x-2
                PO=0
            if x==n//2 and y<n//2 and PO>0:
                if x==n//2 and y==1:
                    cele[x+1][y]='*'
                if x==n//2 and y>1:
                    cele[x][y-1]='*'
                cele[x][y]='A'#<--J
                x=x-1
                PO=0
            if x>1 and y==n//2 and PO>0:
                if x==n//2 and y==n//2:
                    cele[x][y-1]='*'
                if x>1 and y==n//2 and x<n//2:
                    cele[x+1][y]='*'
                cele[x][y]='A'#<--K
                x=x-2
                y=y-1
                PO=0
            if x==1 and y==n//2 and PO>0:
                cele[x+1][y]='*'
                cele[x][y]='A'#<--L
                x=x-1
                PO=0
            if y==n//2+1 and x<n//2+1 and PO>0 and PO_A>0:
                if x==1 and  y==n//2+1:
                    cele[x][y-1]='*'
                if x==2 and y==n//2+1:
                    cele[x-1][y]='*'
                if y==n//2+1 and x>2 and x<n//2+1:
                    cele[x-1][y]='D'
                cele[x][y]='A'#<--M
                y=y-1
                PO=0
        nakresli(cele)
        if x==q and y==w: #ak panáčik A stúpne na panáčika B, vyhodí ho
            hB=0
            PB=0
            q=n-2
            w=n//2-1
        if PA==dlzka_trasy_A-1:
            hA=0
            PA=0
            x=1
            y=n//2+1
            dlzka_trasy_A=dlzka_trasy_A-1
            pocet_panacikov_A=pocet_panacikov_A-1
        if pocet_panacikov_A==0:
            print('Vyhral A')
            break
    #pohyb hráča B
    hod_B=random.randint(1,6)
    if PB==0 and hod_B==6:
        cele[n][n//2]='B'
        print('HRAC B HODIL 6!')
        print()
        nakresli(cele)
        hB=hB+1
    if hB==1:
        hod_B=random.randint(1,6)
        if PB+hod_B>dlzka_trasy_B-1:
            print()
            print('Hráč B hodil: ',hod_B)
            hod_B=0
            print('Neplatný hod hráča B: 0')
            print()
        else:
            print()
            print('Hráč B hodil: ',hod_B)
            print()
        for i in range(hod_B):
            PB=PB+1
            PO=PO+1
            PO_A=PO_A+1
            q=q+1
            w=w+1
            if q>n//2+2 and w==n//2 and PO>0:
                if q==n and w==n//2:
                    cele[q][w+1]='*'
                if q>n//2+2 and q<n and w==n//2:
                    cele[q+1][w]='*'
                cele[q][w]='B'#<--G
                w=w-1
                q=q-2
                PO=0
            if q==n//2+2 and w<n//2+1 and w>1 and PO>0:
                if q==n//2+2 and w==n//2:
                    cele[q+1][w]='*'
                if q==n//2+2 and w<n//2:
                    cele[q][w+1]='*'
                cele[q][w]='B'#<--H
                q=q-1
                w=w-2
                PO=0
            if w==1 and q>n//2 and PO>0:
                if w==1 and q==n//2+2:
                    cele[q][w+1]='*'
                if w==1 and q==n//2+1:
                    cele[q+1][w]='*'
                cele[q][w]='B'#<--I
                w=w-1
                q=q-2
                PO=0
            if q==n//2 and w<n//2 and PO>0:
                if q==n//2 and w==1:
                    cele[q+1][w]='*'
                if q==n//2 and w>1:
                    cele[q][w-1]='*'
                cele[q][w]='B'#<--J
                q=q-1
                PO=0
            if q>1 and w==n//2 and PO>0:
                if q==n//2 and w==n//2:
                    cele[q][w-1]='*'
                if q>1 and w==n//2 and q<n//2:
                    cele[q+1][w]='*'
                cele[q][w]='B'#<--K
                q=q-2
                w=w-1
                PO=0
            if q==1 and w<n//2+2 and PO>0:
                if q==1 and w==n//2+1:
                    cele[q][w-1]='*'
                if q==1 and w==n//2:
                    cele[q+1][w]='*'
                cele[q][w]='B'#<--L
                q=q-1
                PO=0
            if q<n//2 and w==n//2+2 and PO_A>0:
                if q==1 and w==n//2+2:
                    cele[q][w-1]='*'
                    cele[q-1][w]=n//2+1
                if q>1 and q<n//2+1 and w==n//2+2:
                    cele[q-1][w]='*'
                cele[q][w]='B'#<--A
                w=w-1
                PO_A=0
            if q==n//2 and w<n and w>n//2+1:
                if q==n//2 and w!=n//2+2:
                    cele[q][w-1]='*'
                if q==n//2 and w==n//2+2:
                    cele[q-1][w]='*'
                cele[q][w]='B'#<--B
                q=q-1
            if w==n and q<n//2+2 and q>n//2-1:
                cele[q-1][w]='*'
                if q==n//2 and w==n:
                    cele[q][w-1]='*'
                    cele[q-1][w]=''
                cele[q][w]='B'#<--C
                w=w-1
            if q==n//2+2 and w>n//2+2:
                if q==n//2+2 and w==n:
                    cele[q-1][w]='*'
                if q==n//2+2 and w<n:
                    cele[q][w+1]='*'
                cele[q][w]='B'#<--D
                w=w-2
                q=q-1
            if w==n//2+2 and q<n and q>n//2+1:
                if w==n//2+2 and q==n//2+2:
                    cele[q][w+1]='*'
                if q>n//2+2 and w==n//2+2:
                    cele[q-1][w]='*'
                cele[q][w]='B'#<--E
                w=w-1
                PO=0
            if q==n and w==n//2+2 and PO>0:
                if q==n and w==n//2+2:
                    cele[q-1][w]='*'
                if q==n and w==n//2+1:
                    cele[q][w+1]='*'
                cele[q][w]='B'#<--F
                w=w-2
                q=q-1
                PO=0
            if w==n//2+1 and q>n//2+1 and PO>0 and PO_A>0:
                if q==n and  w==n//2+1:
                    cele[q][w+1]='*'
                if q==n-1 and w==n//2+1:
                    cele[q+1][w]='*'
                if w==n//2+1 and q<n-1 and q>n//2+1:
                    cele[q+1][w]='D'
                cele[q][w]='B'#<--M
                q=q-2
                w=w-1
                PO=0
        nakresli(cele)
        if q==x and w==y: #ak panáčik B stúpne na panáčika A, vyhodí ho
            hA=0
            PA=0
            x=1
            y=n//2+1
        if PB==dlzka_trasy_B-1:
            hB=0
            PB=0
            q=n-2
            w=n//2-1
            dlzka_trasy_B=dlzka_trasy_B-1
            pocet_panacikov_B=pocet_panacikov_B-1
        if pocet_panacikov_B==0:
            print('VYHRAL B')
            break



