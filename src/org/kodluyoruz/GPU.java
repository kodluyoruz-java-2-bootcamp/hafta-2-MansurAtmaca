package org.kodluyoruz;

/**
 * Bu sınıf bir ekran kartını temsil eder.
 * TODO Bu sınıfı Hardware sınıfının alt sınıfı haline getirin.
 *
 * Her ekran kartının Hardware sınıfındakilere ek olarak 2 özelliği vardır:
 *      - Hafıza boyutu (memory) (int türünde) Örnek: 4 GB, 8 GB vs.
 *      - Renk skalası (bits) (int türünde) Örnek: 128 bits, 256 bits vs.
 *
 * TODO Bu 2 özellik ve bunların metotları için gereken kodları bu sınıfın içine yazın
 */
public class GPU extends Hardware
{
    private int memory;
    private int bits;

    public GPU() {
    }

    public GPU(String brand, double price, int power, int memory, int bits) {
        super(brand, price, power);
        this.memory = memory;
        this.bits = bits;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    @Override
    public double getPrice() {
        if (memory>8&&bits>128){
          int extraMemory=  ((memory-8)/2)*250;
          int extraBits=((bits-128)/64)*400;

          return super.getPrice()+extraMemory+extraBits;
        }
        else if (memory>8&&bits<=128){
            int extraMemory=  ((memory-8)/2)*250;
            return super.getPrice()+extraMemory;
        }
        else if (memory<=8&&bits>128){
            int extraBits=((bits-128)/64)*400;
            return super.getPrice()+extraBits;
        }
        else
        return super.getPrice();
    }
    /*
     * Eğer ekran kartının hafızası 8 GB'tan fazlaysa, her 2 GB için fiyatı 250 TL artar.
     * Eğer ekran kartının renk skalası 128 bits'ten fazlaysa, her 64 bits için fiyatı 400 TL artar.
     * TODO buna göre Hardware sınıfındaki fiyat hesaplayan metodu bu sınıfta yeniden yazın
     */

}
