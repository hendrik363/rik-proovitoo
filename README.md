# java programmeerija prooviülesanne

## Prooviülesande nõuded

### Mittefunktsionaalsed nõuded
· Veebirakendus peab olema realiseeritud Java programmeerimiskeeles uusimat raamistikku kasutades.

· Arendusvahendina on soovitatav kasutada uusimat IntelliJ IDEA versiooni (viimane IntelliJ IDEA Community versioon on alla laaditav siit: https://www.jetbrains.com/idea/download/)

· Rakenduse kood peab olema vigadeta kompileeruv ning eelneva seadistuseta IDEA’s avatav ning käivitatav.

· Kasutajaliides peab vastama HTML5 standardile ning kasutajaliidese loomisel on soovitatav võtta aluseks mõni raamistik (näiteks Bootstrap).

· Kasuta töös avalikult kättesaadavat Git repositooriumi (näiteks üks kolmest kõige levinumast: GitHub, GitLab või Bitbucket). Töö käik peab olema hindaja poolt versioonihaldusest selgelt jälgitav.

### Funktsionaalsed nõuded

Veebirakendus peab koosnema järgmistest vaadetest:

· Avaleht

· Ürituse lisamise vaade

· Üritusest osavõtvate isikute vaade

· Osavõtja lisamise vaade

· Osavõtja detailandmete vaatamise/muutmise vaade

Avaleht – Sisaldab loetelu toimunud ja tulevikus toimuvatest üritustest. Visuaalselt kuvatakse ürituse nimi, aeg, koht, osavõtjate arv. Link või nupp osavõtja lisamiseks (mis viib osavõtja lisamise vormile) ja ürituse kustutamise võimalus tulevikus toimuvate ürituste osas (kustutab nii ürituse kui ka üritusele registreerunud osavõtjad). Lisaks peab olema võimalus liikuda ürituse lisamise vormile.

Ürituse lisamise vaade – Sisaldab vormi, millega saab lisada uusi tulevikus toimuvaid üritusi. Vormilt peaks saama sisestada järgmiseid andmeid: ürituse nimi, toimumisaeg (saab sisestada ainult tuleviku kuupäeva ja kellaaega), toimumise koht, lisainfo (maksimaalselt 1000 tähemärki), lisamise nupp ja tagasi nupp avalehele navigeerimiseks. Peale ürituse lisamist võiks toimuda automaatne suunamine avalehele.

Üritusest osavõtvate isikute vaade – Vajutades avalehel ürituse nimele peaks avanema vaade kõikide üritusest osavõtvate isikute loeteluga. Loetelus peaks iga isiku kohta olema ees- ja perekonnanimi (ettevõtte puhul juriidiline nimi), isikukood (ettevõtte puhul registrikood), ürituselt kustutamise võimalus ning tagasi nupp avalehele navigeerimiseks.

Osavõtja lisamise vaade – Avalehel on iga ürituse taga nupp või link osavõtja lisamiseks, mis viib eraldi vormile. Vormil peab olema valik kas soovitakse lisada füüsilist või juriidilist isikut ning vastavalt tehtud valikule peab olema võimalik sisestada järgmiseid andmeid:

Eraisik 

· Eesnimi 

· Perekonnanimi 

· Isikukood 

· Osavõtumaksu maksmise viis (valik:

· pangaülekanne või sularaha) 

· Lisainfo väli (maksimaalselt 1500 tähemärki), osalejapoolsed soovid 

Ettevõte

Ettevõtte juriidiline nimi

· Ettevõtte registrikood

· Ettevõttest tulevate osavõtjate arv

· Osavõtumaksu maksmise viis (valik: pangaülekanne või sularaha)

· Lisainfo väli (maksimaalselt 5000 tähemärki), osalejapoolsed soovid



Teeme eelduse, et kõikidel füüsilisest isikust osavõtjatel on Eesti isikukoodi ning sisestamisel valideeritakse selle korrektsust.

Makseviise peab saama hallata ilma lähtekoodi muutmata. Vormil on lisaks salvestamise nupp ja tagasi nupp avalehele navigeerimiseks. Peale osavõtja lisamist võiks toimuda automaatne avalehele suunamine.

Osavõtja detailandmete vaatamise/muutmise vaade – üritusest osavõtvate isikute vaatest isikule vajutades avaneb vaade, kus on võimalik vaadata ja muuta osavõtja lisamise vormilt salvestatud andmeid.
