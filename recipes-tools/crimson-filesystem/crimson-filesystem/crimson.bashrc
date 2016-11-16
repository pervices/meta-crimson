#
# ~/.bashrc
#
# Normal Colors

if [ -x /etc/crimson/motd ]; then
    /etc/crimson/./motd   # Print welcome message
fi

# If not running interactively, don't do anything
[[ $- != *i* ]] && return
export PS1='[\[\e[1;32m\]\u\[\e[1;0m\]@\h \W]\$ '

alias ls='ls --color'
export LS_COLORS='di=1;34:fi=0:ln=1;36:ex=1;32:bd=1;93:cd=1;93'
