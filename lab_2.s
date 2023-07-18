	AREA fact,CODE,READONLY
	EXPORT __main
__main
	ENTRY
	MOV R0,#7
	MOV R1,R0
Repeat SUBS R1,R1,#1
	CMP R1,#0
	BEQ STOP
	MUL R0,R0,R1
	BNE Repeat
STOP 
	NOP; NOP - no operation
	END