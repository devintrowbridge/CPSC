; template to start a new project 
; 12/29/2017 Saad Biaz
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	
.code
main proc
  mov eax, 0FFFDh
  inc eax
  inc eax
  inc eax

  mov eax, 0FFFDh
  inc AL
  inc AL
  inc AL

	invoke ExitProcess,0
main endp
end main