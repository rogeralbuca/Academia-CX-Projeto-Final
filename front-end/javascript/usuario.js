const usuarioLogado = {};

export function setUsuario(user) {
  usuarioLogado.id = user.id;
  usuarioLogado.nome = user.nome;
  window.sessionStorage.setItem('usuarioLogado', JSON.stringify(usuarioLogado));
}

export function getUsuario() {
  return (
    JSON.parse(window.sessionStorage.getItem('usuarioLogado')) || usuarioLogado
  );
}
