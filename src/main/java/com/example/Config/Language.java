package com.example.Config;

import java.util.*;

public class Language {
   //private List<String> fieldsNames = new ArrayList<String>();
    private Map<String,String> fieldsNames = new HashMap<String, String>();

    public void getLT()
    {
        // LOGIN
        fieldsNames.put("titleOne","IT Akademijos Bankas");
        fieldsNames.put("titleTwo","Fianansų konsultacijos");

        fieldsNames.put("loginTitle","PRISIJUNKITE");
        fieldsNames.put("loginEmail","El. paštas");
        fieldsNames.put("loginPassword","Slaptažodis");
        fieldsNames.put("loginButtonLogin","Prisijungti");
        fieldsNames.put("loginButtonRegister","Prisiregistruoti");
        fieldsNames.put("loginCookie","Likti prisijungus");

        fieldsNames.put("loginError","Nėra tokio vartotojo registruoto el. pašto");
        fieldsNames.put("loginError2","Neteisingas slaptažodis");

        //  HOME

        fieldsNames.put("homeTitle", "SUSISIEKITE SU MUMIS");
        fieldsNames.put("homeButtonWrite", "Parašykite");
        fieldsNames.put("homeButtonRegister", "Registruokitės");
        fieldsNames.put("homeButtonHistory", "Mano registracijos");
        fieldsNames.put("homeFooterText","Jei klausimas susijęs su Jūsų finansine informacija „IT Akademijos Bankas, paskambinus telefonais 1234 ir 4321 informaciją suteiksime nustatę Jūsų kaip banko kliento tapatybę. ");

        //  CONTACT

        fieldsNames.put("contactTitle","Parašykite mums");
        fieldsNames.put("contactMessage","Žinutės tekstas");
        fieldsNames.put("contactAnswer","Kaip pageidaujate gauti atsakymą");
        fieldsNames.put("contactAnswerList1","Telefonu");
        fieldsNames.put("contactAnswerList2","El. paštu");
        fieldsNames.put("contactAnswerList3","El. paštu ir telefonu");
        fieldsNames.put("contactFooterText","Į pateiktus klausimus atsakome darbo dienomis 8–20 val., šeštadieniais 9–16 valandomis. Jeigu Jums reikalinga skubi " +
                "informacija, laukiame jūsų skambučių tel. 1884 (privatiems klientams) bei 1633 (verslo klientams). Iš užsienio skambinkite tel. +370 5 268 4444 " +
                "(privatiems klientams) bei +370 5 268 4422 (verslo klientams).”");

        fieldsNames.put("contactError","Užpildykite privalomus laukus");

        // CONTACT CONFIRMATION

        fieldsNames.put("contactConfirmText","Sveiki,\n" +
                "dėkojame, kad kreipiatės į „IT Akademijos Bankas“.\n" +
                "Į pateiktus klausimus atsakome darbo dienomis 8–20 val., šeštadieniais 9–16 valandomis. Jeigu Jums reikalinga skubi informacija, " +
                "laukiame Jūsų skambučių telefonu 1884 arba tel. +370 5 268 4444, jei skambinate iš užsienio. Linkime geros dienos!\n");

        //  REGISTRATION

        fieldsNames.put("registrationTitle","Registruokitės konsultacijai internetu");
        fieldsNames.put("registrationBankDepartment","Banko skyrius");
        fieldsNames.put("registrationBankDepartmentList1","Antakalnio g. 45");
        fieldsNames.put("registrationBankDepartmentList2","Ateities g. 91 (PC Mandarinas)");
        fieldsNames.put("registrationBankDepartmentList3","Gedimino pr. 56");
        fieldsNames.put("registrationBankDepartmentList4","Konstitucijos pr. 20A, dirba Būsto Centras");
        fieldsNames.put("registrationBankDepartmentList5","Ozo g. 25 (PPC „Akropolis“)");
        fieldsNames.put("registrationDate","Data");
        fieldsNames.put("registrationTime","Konsultacijos laikas");
        fieldsNames.put("registrationMessage","Pastabos, komentarai");

        //  REGISTRATION CONFIRMATION

        fieldsNames.put("registrationConfirmationTitle","Registracijos patvirtinimas");
        fieldsNames.put("registrationFooterText", "Ačiū, kad domitės banko paslaugomis.\n" +
                "Jeigu Jums reikalinga skubi informacija, laukiame Jūsų skambučių telefonu 1884, darbo dienomis 8-20 val., šeštadieniais 9-16 val.\n");

        // REGISTRATION AND CONTACT

        fieldsNames.put("name","Vardas");
        fieldsNames.put("surname","Pavardė");
        fieldsNames.put("phone","Telefonas");
        fieldsNames.put("email","El. paštas");

        fieldsNames.put("theme","Tema");
        fieldsNames.put("themeList1","Taupymas ir investavimas;");
        fieldsNames.put("themeList2","Pensijos ir kaupimas;");
        fieldsNames.put("themeList3","Gyvybės draudimas;");
        fieldsNames.put("themeList4","Ne gyvybės draudimas;");
        fieldsNames.put("themeList5","Paskolos, lizingas;");
        fieldsNames.put("themeList6","Kasdienių finansų valdymas.");

        // HISTORY

        fieldsNames.put("historyTitle","Registracijos internetu");
        fieldsNames.put("historyButtonLook","Peržiūrėti");
        fieldsNames.put("historyButtonDelete","Atsisakyti");

        // MISC
        fieldsNames.put("buttonSend","Siųsti");
        fieldsNames.put("buttonBack","< Atgal");
    }
}
