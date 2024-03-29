# java programmeerija prooviülesanne

## Rakenduse jooksutamise käsurea käsud
### Compile
& "<mvnw.cmd path>" compile -f "<pom.xml path>"

### Package
& "<mvnw.cmd path>" package -f "<pom.xml path>"

### Run
java -jar ./target/rik-proovitoo.jar

## Sissejuhatus

Käesolev projekt on mõeldud ürituste lisamiseks/haldamiseks. Projektis on kasutusel Java Spring boot raamistik ning frontendiks on HTML, CSS ja javascript. Projektil on ka töötav API lingil: http://localhost:8080/api/v1/events. Andemed salvestatakse mysql andmebaasi.

## Prooviülesande nõuded


### Mittefunktsionaalsed nõuded
· Veebirakendus peab olema realiseeritud Java programmeerimiskeeles uusimat raamistikku kasutades.
- Kasutasin Java Spring Boot 3.2.1 raamistikku veebirakenduse arenduseks.

· Arendusvahendina on soovitatav kasutada uusimat IntelliJ IDEA versiooni (viimane IntelliJ IDEA Community versioon on alla laaditav siit: https://www.jetbrains.com/idea/download/)
- Proovisin ja katsetasin IntelliJ IDEA arendusvahendina, kuid läksin tagasi VScode peale, kuna tunnen selle peal ennast kõige mugavamalt.

· Rakenduse kood peab olema vigadeta kompileeruv ning eelneva seadistuseta IDEA’s avatav ning käivitatav.
- Katsetasin kompileerumist ja avamist IDEA's ning mul toimis ilma vigadeta.

· Kasutajaliides peab vastama HTML5 standardile ning kasutajaliidese loomisel on soovitatav võtta aluseks mõni raamistik (näiteks Bootstrap).
- Disainisin veebirakenduse kasutades HTML'i ja Bootstrapi. Vajalikudes kohtades kirjutasin oma css'i. Kasutasin javascripti, nimelt Osavõtja lisamise vaates, sest tahtsin, et form muutuks realajas olenevalt, kas kasutaja on valinud Ettevõte või Eraisik.

· Kasuta töös avalikult kättesaadavat Git repositooriumi (näiteks üks kolmest kõige levinumast: GitHub, GitLab või Bitbucket). Töö käik peab olema hindaja poolt versioonihaldusest selgelt jälgitav.
- Praegune GitHub repositoorium on avalikult kättesaadav.

### Funktsionaalsed nõuded

Veebirakendus peab koosnema järgmistest vaadetest:

· Avaleht
- Avalehe disainisin tänu pildile, mille leidsin "UI Materjal" kaustast.

· Ürituse lisamise vaade
- Ürituse lisamise vaate disainisin tänu pildile, mille leidsin "UI Materjal" kaustast. Javascriptiga kontrollin, et kuupäev oleks tulevikus.

· Üritusest osavõtvate isikute vaade
- Üritusest osavõtvate isikute vaate disainisin tänu pildile, mille leidsin "UI Materjal" kaustast.

· Osavõtja lisamise vaade
- Osavõtja lisamise vaade on osa Üritusest osavõtvate isikute vaate lehest. Nii nagu "UI Materjal" kaustas oleval pildil. Lehel on kaks radio buttonit Eraisik ja Ettevõte. Valides ühe neist muutub all olev Form järgnevalt Ettevõte ja Eraisiku andmetele. Kuna nägin, et osavõtjaid saab lisada ainult ürituste külge, siis disainisin lehe nii, et osavõtjaid saab lisada ainult ürituse külge. Kui peab olema võimalik lisada osalejaid eraldi, siis palun andke teada.

· Osavõtja detailandmete vaatamise/muutmise vaade
- Tegin kaks eraldi lehte osavõtja detailandmete vaatamise/muutmise vaate jaoks. Lehe form oleneb sellest, kas osaleja on Ettevõte või Eraisik:

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

#### Lisainfo: Kasutasin Thymeleaf'i, et siduda frontend ja backend andmeid. 

## Andmebaas

Mysql andmebaasi seadistasin kastades rakendust MAMP. Mysql port on seadistuses 8889 ning apache port on 8888. Seadistasin, ainult ühe tabeli ürituste jaoks(tabel name: events). Üritus koosneb järgnevatest väljadest: 
- ID (Auto Increment) (Andmetüüp Integer) (PRIMARY)
- NAME (Nimi) (Andmetüüp TEXT)
- DATETIME (ürituse aeg) (Andmetüüp TEXT)
- LOCATION (Asukoht) (Andmetüüp TEXT)
- INFROMATION (ürituse lisainfo) (Andmetüüp TEXT)
- PARTICIPANTS (Eraisikust osavõtjad) (Andmetüüp JSON)
- COMPANY_PARTICIPANTS (Ettevõte osavõtjad) (Andmetüüp JSON)
- ALL_PARTICIPANTS (Kõik osavõtjad) (Andmetüüp JSON)

#### Leiate pildi andmebaasi struktuurist projekti failide hulgast: andmebaas.jpg








