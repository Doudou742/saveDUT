PATH=/usr/bin:$PATH

if ! test -d node_modules
then
  echo Chargement des dépendances
  export http_proxy=http://cache.univ-lille1.fr:3128
  export https_proxy=https://cache.univ-lille1.fr:3128
  export HTTPS_PROXY=https://cache.univ-lille1.fr:3128
  npm install
fi

node server.js
