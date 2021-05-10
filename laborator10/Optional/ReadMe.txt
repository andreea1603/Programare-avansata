(*) Pentru a implementa comenzile cerute, am creat o clasa(Users) in care se vor retine numele tuturor utilizatorilor si o lista ce va contine toate prieteniile formate intre acestia.

(*) Clasa Buffer contine o variabila de tip Users si o lista in care sunt retinute mesajele trimise de la un utilizator catre toti prietenii sai; aceste resurse se vor actualiza la fiecare comanda a fiecarui utilizator;

(*) Clasa Command contine executia comenzilor date de utilizator: 
          -pentru login, se va cauta username-ul in lista de utilizatori, si se va putea loga, daca acesta exista; 
          -pentru register,  se va adauga in lista de mai sus noul username;
          -pentru friend, se vor adauga in lista de prietenii username-urile trimise ca  parametrii;
          -pentru send, in lista de mesaje, se va adauga numele user-ului si mesajul transmis;
          -pentru read, se vor citi din lista de mesaje toate mesajele ce au fost transmise de catre un prieten al                  userului curent.

(*) Clasa Friendship creeaza o noua prietenie intre doi useri;

(*) Clasa Messages contine numele user-ului si a mesajului corespunzator, ajutand la transmiterea mesajelor
