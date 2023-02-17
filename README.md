# RPGHeroes
* A program that consists of an abstract Hero class with a set of Hero subclasses that can level up, deal damage, equip armor, and equip weapons.
* Every Hero has attributes which are upgraded upon level up and enhanced by the different armor pieces the Hero is wearing.
* Each subclass can wear specific types of armor and wield specific types of weapons.  Once a Hero equips an invalid armor or weapon type a custom exception is thrown explaining why said hero can't wear the provided armor/weapon in adequate detail.
* To make sure the code functions correctly a plethora of JUnit tests are ran. A CI file which autoruns the tests every push to this repo was also made by utilizing GitHub Actions. 

## Project structure
* Heroes package
  * HeroAttribute
  * Hero | *utilizes HeroAttribute, Armor, and Weapon* & *throws InvalidArmorException and InvalidWeaponException*
  * Mage | *extends Hero*
  * Ranger | *extends Hero*
  * Rogue | *extends Hero*
  * Warrior | *extends Hero*
* Items package
  * Abstract Item
  * Enum Slot
  * /Armor
    * Armor | *extends Item* & *utilizes ArmorType, Slot, and HeroAttribute*
    * Enum ArmorType
  * /Weapon
    * Weapon | *extends Item* & *utilizes WeaponType and Slot*
    * Enum WeaponType
* InvalidArmorException
* InvalidWeaponException
