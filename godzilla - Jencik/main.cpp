#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "data.h"
#include "rng.h"


int main(int argc, char *argv[]) {
    char *pEnd;
    int i=0;
    Unit enemy[1000];
    int pocet_jednotiek;
    int cislo_seedu;
    Unit Monster;
    while (i<MONSTER_TYPE_COUNT) {
        if (strcmp(argv[1], monster_types[i].name) == 0){
            Monster.type=monster_types[i].name;
            Monster.hp=MONSTER_INITIAL_HP;
            Monster.level=0;
        }
        i++;
    }
    printf("%s, ATT:%d DEF:%d, HP:%d, LVL:%d\n",Monster.type->name,Monster.type->att,Monster.type->def,Monster.hp,Monster.level);
    pocet_jednotiek = strtol(argv[2],&pEnd,10);
    cislo_seedu = strtol(argv[3],&pEnd,10);
    srnd(cislo_seedu);
    Unit vojak;
    if (argv[3]=="i file_path")
        for (i=0;i<pocet_jednotiek;i++){
            vojak.type = enemy_types[rnd(0,ENEMY_TYPE_COUNT-1)].name;
            vojak.hp = rnd(ENEMY_MIN_INIT_HP,ENEMY_MAX_INIT_HP);
            vojak.level= rnd(0,UNIT_MAX_LEVEL);
            printf("[%d] %s, ATT:%d DEF:%d, HP:%d, LVL:%d\n",i,vojak.type->name,vojak.type->att,vojak.type->def,vojak.hp,vojak.level);
            enemy[i]=vojak;
        }
    printf("\n");
    //------------------------------------
    int base_dmg=0, strength=0, defense=0,DMG=0;
    int j;
    i=0;
    int Utocnik=1;
    int ujo=0;
    int army=0;
    int dead=0;
    int c1=0,c2=0,c3=0,d1=0,d2=0,d3=0;
    Unit attacker;
    Unit defender;
    int hp_najmenej=enemy[0].hp;
    int poc=0;
    int total_enemies_DMG=0;
    int total_Monster_DMG=0;
    while (Monster.hp!=0 && dead!=pocet_jednotiek)
    {
        j=0;
        hp_najmenej=1000;
        while (enemy[j].type!=NULL) {
            if (enemy[j].hp < hp_najmenej && enemy[j].hp > 0){
                hp_najmenej = enemy[j].hp;
                poc=j;
            }
            j++;
        }
        if (Utocnik==1) {
            attacker.type = Monster.type;
            attacker.hp = Monster.hp;
            attacker.level = Monster.level;
            defender.type = enemy[poc].type;
            defender.hp = hp_najmenej;
            defender.level = enemy[poc].level;
            //
            c1=rnd(1,attacker.hp);
            c2=attacker.type->att;
            d1=rnd(1,defender.hp);
            d2=defender.type->def;
            base_dmg=30+attacker.level-defender.level;
            strength=100+c1+c2;
            defense=100+d1+d2;
            DMG=(base_dmg*strength)/defense;
            total_Monster_DMG=total_Monster_DMG+DMG;
            //
            printf("%s => %d => [%d] %s\n", Monster.type, DMG, poc, enemy[poc].type);
            enemy[poc].hp=enemy[poc].hp-DMG;
            if (enemy[poc].hp<=0){
                dead=dead+1;
            }
            Utocnik = 0;
        }
        army=0;
        if (Utocnik==0) {
            while (army < pocet_jednotiek) {
                //
                attacker.type = enemy[army].type;
                attacker.hp = enemy[army].hp;
                attacker.level = enemy[army].level;
                defender.type = Monster.type;
                defender.hp = Monster.hp;
                defender.level = Monster.level;
                //
                if (enemy[army].hp > 0) {
                    c1= rnd(1,attacker.hp);
                    d1 = rnd(1, defender.hp);
                    c2=attacker.type->att;
                    d2=defender.type->def;
                    base_dmg=30+attacker.level-defender.level;
                    strength=100+c1+c2;
                    defense=100+d1+d2;
                    DMG=(base_dmg*strength)/defense;
                    printf("[%d] %s => %d => %s\n", army, enemy[army].type, DMG, Monster.type);
                    Monster.hp = Monster.hp - DMG;
                    total_enemies_DMG=total_enemies_DMG+DMG;
                }
                army++;
            }
            Utocnik=1;
            printf("\n");
            //--------
            printf("%s, ATT:%d DEF:%d, HP:%d, LVL:%d\n",Monster.type->name,Monster.type->att,Monster.type->def,Monster.hp,Monster.level);
            for (army=0;army<pocet_jednotiek;army++){
                printf("[%d] %s, ATT:%d DEF:%d, HP:%d, LVL:%d\n",army,enemy[army].type->name,enemy[army].type->att,enemy[army].type->def,enemy[army].hp,enemy[army].level);
            }
            printf("\n");
            //--------
        }
        Monster.level=Monster.level+1;
        i++;
    }
    if (Monster.hp>0){
        printf("Winner: %s\n",Monster.type);
    }
    else{
        printf("Winner: Enemy\n");
    }
    printf("Total monster DMG: %d\n",total_Monster_DMG);
    printf("Total monster DMG: %d",total_enemies_DMG);

    //------------------------------------

    return 0;
}
