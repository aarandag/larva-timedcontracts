grammar ContractsToLarva;

@header {
    import java.util.ArrayList;
    import org.stringtemplate.v4.*;
    import contractModels.*;
}

@members {
    static ArrayList<Event> l_events = new ArrayList<Event>();
}
	 

s : contract EOF {
    System.out.println($contract.def);
    STGroup stGroup = new STGroupFile("larva_templates.stg");
    ST template = stGroup.getInstanceOf("automaton_definition");
    template.add("contract", $contract.def);
    template.add("events", l_events);
    System.out.println(template.render());
};

contract returns [String def]:
SAT {$def = "new TrueContract()";}
| VIO {$def = "new FalseContract()";}
| PCON k=ID PERF a=ID CPARE OBRACK INT CBRACK {/* PermissionContract : Not implemented */}
| OCON k=ID PERF a=ID CPARE OBRACK INT CBRACK {
    l_events.add(new Event($k.text, $a.text));
    $def = "new ObligationContract(new Event(" + $k.text + ", " + $a.text + "), " + $INT.text + ")";
}
| FCON k=ID PERF a=ID CPARE OBRACK INT CBRACK {
    l_events.add(new Event($k.text, $a.text)); 
    $def = "new ProhibitionContract(new Event(" + $k.text + ", " + $a.text + "), " + $INT.text + ")";
}
| WAIT OBRACK INT CBRACK {$def = "new WaitContract(" + $INT.text + ")";}
| l=contract SEQOP r=contract {$def = "new SequentialContract(" + $l.def + "," + $r.def + ")";}  
| l=contract AND r=contract {$def = "new ConjuctionContract(" + $l.def + "," + $r.def + ")";}  
| l=contract OR r=contract {$def = "new DisjuctionContract(" + $l.def + "," + $r.def + ")";}  
| l=contract REPOP r=contract {$def = "new ReparationContract(" + $l.def + "," + $r.def + ")";}  
| REC INT DOT contract {$def = "new RecursiveContract(" + $INT.text + ", " + $contract.def + ")";};

// Define tokens
SAT : 'sat';
VIO : 'vio';
WAIT : 'wait';
REC : 'rec';
AND : '&';
OR : '|';
SEQOP : ';';
REPOP : '>>';
COND : 'cond(';
PCON : 'P(';
OCON : 'O(';
FCON : 'F(';
PERF : '->';
OBRACK : '[';
CBRACK : ']';
CPARE : ')';
DOT : '.';
INT : [0-9]+;
ID : [a-zA-Z]+;
WS : [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines
