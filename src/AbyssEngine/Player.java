package AbyssEngine;

public final class Player {
   public Gun[][] guns;
   private Player[] coPlayers;
   float radius;
   private int empPoints;
   private int maxEmpPoints;
   private int hp;
   private int maxHp;
   private float shield;
   private int maxShield;
   private int armorPoints;
   private int maxArmorPoints;
   private int percentHP;
   private int percentShield;
   private int percentArmor;
   private int percentEMP;
   private int threeSecTick;
   private boolean var_380;
   private boolean var_3a5;
   public boolean var_3df;
   public boolean var_427;
   public boolean hidden;
   public Matrix var_46b;
   private AEVector3D var_4a2 = new AEVector3D();
   private KIPlayer kiPlayer;
   private boolean var_518;
   public boolean var_54e;
   private float reamingNukeStun;
   private float var_5ec;
   private int var_608;
   private int dealtEmpDamage;
   private boolean permanentEnemy;
   private int var_67c;
   private int elapsedEMPstun;
   private boolean stunnedEMP;
   private boolean var_72f;
   private boolean permanentFriend;
   public boolean invincible_;
   public int var_7ae;
   public int var_803;
   public int var_83e;

   public Player(float var1, int var2, int var3, int var4, int var5) {
      this.radius = var1;
      this.hp = var2;
      this.maxHp = var2;
      this.updateDamageRate();
      this.guns = new Gun[3][];
      if (var3 > 0) {
         this.guns[0] = new Gun[var3];
      }

      if (var4 > 0) {
         this.guns[1] = new Gun[var4];
      }

      if (var5 > 0) {
         this.guns[2] = new Gun[var5];
      }

      this.var_46b = new Matrix();
      this.var_380 = true;
      this.var_3a5 = true;
      this.kiPlayer = null;
      this.var_518 = false;
      this.var_54e = false;
      this.invincible_ = false;
   }

   public final boolean isAsteroid() {
      return this.kiPlayer != null ? this.kiPlayer.isAsteroid : false;
   }

   public final void setAlwaysEnemy(boolean var1) {
      this.var_72f = var1;
      this.var_3df = true;
      this.var_427 = false;
      this.permanentEnemy = true;
   }

   public final void setAlwaysFriend(boolean var1) {
      this.permanentFriend = var1;
      this.var_3df = false;
      this.var_427 = true;
      this.permanentEnemy = false;
   }

   public final boolean isAlwaysFriend() {
      return this.permanentFriend;
   }

   public final void sub_137(int var1, int var2) {
      this.empPoints = var1;
      if (this.empPoints > this.maxEmpPoints) {
         this.maxEmpPoints = this.empPoints;
      }

      this.updateDamageRate();
      this.var_67c = var2;
   }

   public final void sub_169(boolean var1) {
      this.var_518 = true;
   }

   public final void setRadius(int var1) {
      this.radius = (float)var1;
   }

   public final void setKIPlayer(KIPlayer var1) {
      this.kiPlayer = var1;
   }

   public final KIPlayer getKIPlayer() {
      return this.kiPlayer;
   }

   public final void sub_20c() {
      this.hp = this.maxHp;
      this.shield = (float)this.maxShield;
      this.updateDamageRate();
      this.var_380 = true;
      this.var_3a5 = true;
      this.var_46b.identity();
      this.var_54e = false;
      this.permanentEnemy = false;
      this.var_608 = 0;
      this.dealtEmpDamage = 0;
      this.hidden = false;
   }

   public final void sub_218(Player[] var1) {
      this.coPlayers = var1;
      if (this.guns != null) {
         for(int var3 = 0; var3 < this.guns.length; ++var3) {
            if (this.guns[var3] != null) {
               for(int var2 = 0; var2 < this.guns[var3].length; ++var2) {
                  if (this.guns[var3][var2] != null) {
                     this.guns[var3][var2].setTargets(this.coPlayers);
                  }
               }
            }
         }
      }

   }

   public final void sub_266(Player[] var1) {
      if (this.coPlayers == null) {
         this.sub_218(var1);
      } else {
         Player[] var2 = new Player[this.coPlayers.length + var1.length];

         int var3;
         for(var3 = 0; var3 < this.coPlayers.length; ++var3) {
            var2[var3] = this.coPlayers[var3];
         }

         for(var3 = 0; var3 < var1.length; ++var3) {
            var2[this.coPlayers.length + var3] = var1[var3];
         }

         this.sub_218(var2);
      }
   }

   public final Player[] getCoPlayers() {
      return this.coPlayers;
   }

   public final Player sub_2f3(int var1) {
      return this.coPlayers[var1];
   }

   public final void setHitPoints(int var1) {
      this.hp = var1;
      if (this.hp > this.maxHp) {
         this.maxHp = this.hp;
      }

      this.updateDamageRate();
   }

   public final void sub_386(int var1) {
      this.shield = (float)var1;
      if (this.shield > (float)this.maxShield) {
         this.shield = (float)this.maxShield;
      }

      this.updateDamageRate();
   }

   public final void sub_3aa(int var1) {
      this.armorPoints = var1;
      if (this.armorPoints > this.maxArmorPoints) {
         this.armorPoints = this.maxArmorPoints;
      }

      this.updateDamageRate();
   }

   public final void setMaxHP(int var1) {
      this.maxHp = var1;
      this.hp = var1;
      this.updateDamageRate();
   }

   public final void sub_434(int var1) {
      this.maxShield = var1;
      this.shield = (float)var1;
      this.updateDamageRate();
   }

   public final void sub_443(int var1) {
      this.maxArmorPoints = var1;
      this.armorPoints = var1;
      this.updateDamageRate();
   }

   public final int sub_49f() {
      return (int)this.shield;
   }

   public final int sub_4f2() {
      return (int)this.shield + this.armorPoints + this.hp;
   }

   public final int sub_53c() {
      return this.armorPoints;
   }

   public final int sub_561() {
      return this.maxArmorPoints;
   }

   public final void sub_56c(float var1) {
      if (this.shield + var1 < (float)this.maxShield) {
         this.shield += var1;
      } else {
         this.shield = (float)this.maxShield;
      }

      this.updateDamageRate();
   }

   public final void sub_5ce() {
      if (this.armorPoints + 1 < this.maxArmorPoints) {
         ++this.armorPoints;
      } else {
         this.armorPoints = this.maxArmorPoints;
      }

      this.updateDamageRate();
   }

   public final void sub_5e9() {
      if (this.hp + 1 < this.maxHp) {
         ++this.hp;
      } else {
         this.hp = this.maxHp;
      }

      this.updateDamageRate();
   }

   public final int getHitpoints() {
      return this.hp;
   }

   public final int sub_66c() {
      return this.maxHp;
   }

   private void updateDamageRate() {
      this.percentHP = (int)((float)this.hp / (float)this.maxHp * 100.0F);
      this.percentShield = (int)(this.shield / (float)this.maxShield * 100.0F);
      this.percentArmor = (int)((float)this.armorPoints / (float)this.maxArmorPoints * 100.0F);
      this.percentEMP = (int)((float)this.empPoints / (float)this.maxEmpPoints * 100.0F);
   }

   public final int sub_6d4() {
      return this.percentHP;
   }

   public final int sub_6f7() {
      return this.percentEMP;
   }

   public final int sub_73a() {
      return this.percentShield;
   }

   public final int sub_76e() {
      return this.percentArmor;
   }

   public final void sub_79a(boolean var1) {
      this.var_3a5 = var1;
   }

   public final void sub_7d0(int var1, int var2, int var3) {
      this.var_4a2.x = var1;
      this.var_4a2.y = var2;
      this.var_4a2.z = var3;
   }

   public final void setNukeStun(float var1) {
      this.reamingNukeStun = var1;
   }

   public final void sub_84b(float var1) {
      this.var_5ec = var1;
   }

   public final float sub_892() {
      return this.reamingNukeStun;
   }

   public final float sub_8c2() {
      return this.var_5ec;
   }

   public final AEVector3D sub_8db() {
      return this.var_4a2;
   }

   public final void damageEmp(int var1, boolean var2) {
      if (this.var_3a5 && this.var_380 && this.empPoints > 0 && this.hp > 0) {
         if (!var2 && this.kiPlayer != null && !this.var_72f && this.kiPlayer.race != 9 && Status.getSystem() != null && this.kiPlayer.race == Status.getSystem().getRace()) {
            this.dealtEmpDamage += var1;
            if (this.dealtEmpDamage > this.maxEmpPoints / 3) {
               this.permanentEnemy = true;
               this.kiPlayer.level.sub_c61(this.kiPlayer.race);
            }
         }

         this.empPoints -= var1;
         if (this.empPoints <= 0) {
            if (!var2 && this.kiPlayer != null) {
               if (!this.var_72f && this.kiPlayer.race != 9 && Status.getSystem() != null && this.kiPlayer.race == Status.getSystem().getRace()) {
                  this.kiPlayer.level.alarmAllFriends(this.kiPlayer.race, false);
               }

               if (!this.kiPlayer.isAsteroid && !this.kiPlayer.var_99f) {
                  Status.getStanding().incStanding2(this.kiPlayer.race);
               }
            }

            float var3 = (float)this.var_67c;
            this.var_5ec = var3;
            this.stunnedEMP = true;
            this.empPoints = 0;
            this.elapsedEMPstun = 0;
         }

         this.updateDamageRate();
      }
   }

   public final void sub_96b(int var1, boolean var2) {
      if (this.var_3a5 && this.var_380 && this.hp > 0) {
         if (!var2 && this.kiPlayer != null && !this.var_72f && this.kiPlayer.race != 9 && Status.getSystem() != null && this.kiPlayer.race == Status.getSystem().getRace()) {
            this.var_608 += var1;
            if (this.var_608 > this.maxHp / 3) {
               this.permanentEnemy = true;
               this.kiPlayer.level.sub_c61(this.kiPlayer.race);
            }

            if (this.kiPlayer != null && this.var_608 > this.maxHp - this.maxHp / 3) {
               this.kiPlayer.level.alarmAllFriends(this.kiPlayer.race, true);
            }
         }

         if ((var1 = (int)this.shield - var1) < 0) {
            this.shield = 0.0F;
            if ((var1 = this.armorPoints - -var1) < 0) {
               this.armorPoints = 0;
               this.hp -= -var1;
            } else {
               this.armorPoints = var1;
            }
         } else {
            this.shield = (float)var1;
         }

         if (this.hp <= 0) {
            this.hp = 0;
            if (var2) {
               this.var_54e = true;
            } else if (this.kiPlayer != null && !this.kiPlayer.isAsteroid && !this.kiPlayer.var_99f) {
               Status.getStanding().sub_24a(this.kiPlayer.race);
            }
         }

         this.updateDamageRate();
      }
   }

   public final boolean sub_992() {
      return this.permanentEnemy;
   }

   public final void sub_9bb() {
      this.permanentEnemy = true;
   }

   public final boolean sub_9e5(int var1) {
      if (var1 < 3 && var1 >= 0) {
         return this.guns[var1] != null;
      } else {
         return false;
      }
   }

   public final AEVector3D sub_a3c(AEVector3D var1) {
      return this.var_46b.getPosition(var1);
   }

   public final void sub_a98(boolean var1) {
      this.var_380 = var1;
   }

   public final boolean sub_ace() {
      return this.var_380;
   }

   public final boolean sub_ae3() {
      return this.hp <= 0;
   }

   public final void removeGuns() {
      this.guns = null;
   }

   public final void sub_b5e(int var1) {
      if (this.guns != null && 0 < this.guns.length && this.guns[0] != null) {
         for(var1 = 0; var1 < this.guns[0].length; ++var1) {
            this.guns[0][var1].timeSinceLastShot = 0;
         }
      }

   }

   public final void sub_b96(int var1, long var2, boolean var4, Matrix var5) {
      if (this.guns != null && var1 < this.guns.length && var1 >= 0 && this.guns[var1] != null) {
         for(int var6 = 0; var6 < this.guns[var1].length; ++var6) {
            if (this.guns[var1][var6].timeSinceLastShot > this.guns[var1][var6].reloadTimeMilis && this.guns[var1][var6].sub_2ea(var5, var2, var4)) {
               this.guns[var1][var6].timeSinceLastShot = 0;
               if (this.var_518) {
                  switch(this.guns[var1][var6].subType) {
                  case 4:
                     GameStatus.soundManager.playSfx(8);
                     break;
                  case 5:
                     GameStatus.soundManager.playSfx(9);
                     break;
                  case 6:
                     GameStatus.soundManager.playSfx(10);
                     break;
                  case 7:
                     GameStatus.soundManager.playSfx(10);
                  }
               }
            }
         }
      }

   }

   public final void sub_bc8(int var1, long var2, boolean var4) {
      this.sub_b96(var1, var2, false, this.var_46b);
   }

   public final boolean sub_c22(int var1, int var2, long var3, boolean var5) {
      Matrix var13 = this.var_46b;
      boolean var4 = false;
      long var9 = var3;
      int var12 = var2;
      var2 = var1;
      Player var11 = this;
      boolean var6 = true;
      if (this.guns != null && var1 < this.guns.length && var1 >= 0 && this.guns[var1] != null) {
         for(int var7 = 0; var7 < var11.guns[var2].length; ++var7) {
            Gun var8;
            if (((var8 = var11.guns[var2][var7]).subType == 7 || var8.subType == 6) && var8.projectilesTimeLeft[0] >= 0) {
               var8.sub_30a();
            } else if (var8.index == var12 && var8.timeSinceLastShot > var8.reloadTimeMilis) {
               if (var8.sub_2ea(var13, var9, var4)) {
                  if (var11.var_518) {
                     switch(var11.guns[var2][var7].subType) {
                     case 4:
                        GameStatus.soundManager.playSfx(8);
                        break;
                     case 5:
                        GameStatus.soundManager.playSfx(9);
                        break;
                     case 6:
                        GameStatus.soundManager.playSfx(10);
                        break;
                     case 7:
                        GameStatus.soundManager.playSfx(10);
                     }
                  }

                  var8.timeSinceLastShot = 0;
                  break;
               }

               if (var8.var_334 <= 0) {
                  var6 = false;
               }
            }
         }
      }

      return var6;
   }

   public final void sub_c78(long var1) {
      this.threeSecTick = (int)((long)this.threeSecTick + var1);
      if (this.threeSecTick > 3000) {
         this.threeSecTick = 0;
      }

      if (this.stunnedEMP) {
         this.elapsedEMPstun = (int)((long)this.elapsedEMPstun + var1);
         this.empPoints = (int)((float)this.elapsedEMPstun / (float)this.var_67c * (float)this.maxEmpPoints);
         if (this.empPoints > this.maxEmpPoints) {
            this.empPoints = this.maxEmpPoints;
            this.stunnedEMP = false;
            this.elapsedEMPstun = 0;
         }

         this.updateDamageRate();
      }

   }
}