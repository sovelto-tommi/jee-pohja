(window["webpackJsonptuotehallinta-react-app"]=window["webpackJsonptuotehallinta-react-app"]||[]).push([[0],[,,,,,,,,function(e,t,n){e.exports=n.p+"static/media/logo.5d5d9eef.svg"},function(e,t,n){e.exports=n(16)},,,,,function(e,t,n){},function(e,t,n){},function(e,t,n){"use strict";n.r(t);var a=n(0),i=n.n(a),l=n(7),r=n.n(l),o=(n(14),n(8)),u=n.n(o),c=(n(15),n(1)),m=n(2),s=n(4),h=n(3),p=n(5),j=function(e){function t(){return Object(c.a)(this,t),Object(s.a)(this,Object(h.a)(t).apply(this,arguments))}return Object(p.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){var e;return e=i.a.createElement("p",null,"Toinen komponentti"),i.a.createElement("div",null,i.a.createElement("div",null,e),i.a.createElement("p",null))}}]),t}(a.Component),d=function(e){var t=e.kirja,n=t.nimi,a=t.hinta,l=t.kirjailijat;return i.a.createElement("tr",null,i.a.createElement("td",null,n),i.a.createElement("td",null,a),i.a.createElement("td",null,l[0].etunimi))},k="/api/kirjat";var f=function(e){function t(e){var n;return Object(c.a)(this,t),(n=Object(s.a)(this,Object(h.a)(t).call(this,e))).arvoMuuttunut=function(e){var t={};t[e.target.name]=e.target.value,n.setState(t)},n.laheta=function(){n.props.vanhemmanFunktio(n.state),n.setState({nimi:"",hinta:0,kieli:""})},n.state={nimi:"",hinta:0,kieli:"suomi",editio:"1st",kirjailijat:[{id:3}],kustantaja:{id:1},isbn13:"978-0596009205",isbn10:"0596009208"},n}return Object(p.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){return i.a.createElement("form",null,i.a.createElement("p",null,i.a.createElement("label",{htmlFor:"lomake.nimi"},"Nimi: "),i.a.createElement("input",{type:"text",id:"lomake.nimi",name:"nimi",value:this.state.nimi,onChange:this.arvoMuuttunut})),i.a.createElement("p",null,i.a.createElement("label",{htmlFor:"lomake.hinta"},"Hinta: "),i.a.createElement("input",{type:"number",id:"lomake.hinta",name:"hinta",value:this.state.hinta,onChange:this.arvoMuuttunut})),i.a.createElement("p",null,i.a.createElement("label",{htmlFor:"lomake.kieli"},"Kieli: "),i.a.createElement("input",{type:"text",id:"lomake.kieli",name:"kieli",value:this.state.kieli,onChange:this.arvoMuuttunut})),i.a.createElement("p",null,i.a.createElement("input",{type:"button",defaultValue:"L\xe4het\xe4",onClick:this.laheta})))}}]),t}(a.Component),E=function(e){function t(e){var n;return Object(c.a)(this,t),(n=Object(s.a)(this,Object(h.a)(t).call(this,e))).haeKirjat=function(){fetch(k).then((function(e){return e.json()})).then((function(e){n.setState({kirjat:e})}))},n.uusiKirja=function(e){console.log("L\xe4hetet\xe4\xe4n",e),function(e){return fetch(k,{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(e)})}(e).then((function(e){console.log("tuli vastaus",e),n.haeKirjat()}))},n.state={kirjat:[]},n}return Object(p.a)(t,e),Object(m.a)(t,[{key:"componentDidMount",value:function(){this.haeKirjat()}},{key:"render",value:function(){return i.a.createElement("div",null,i.a.createElement(v,{kirjat:this.state.kirjat}),i.a.createElement("hr",null),i.a.createElement(f,{vanhemmanFunktio:this.uusiKirja}))}}]),t}(a.Component),v=function(e){function t(){return Object(c.a)(this,t),Object(s.a)(this,Object(h.a)(t).apply(this,arguments))}return Object(p.a)(t,e),Object(m.a)(t,[{key:"render",value:function(){var e=this.props.kirjat.map((function(e){return i.a.createElement(d,{kirja:e,key:e.id})}));return i.a.createElement("div",{className:"KirjaLista"},i.a.createElement("table",null,i.a.createElement("tbody",null,e)))}}]),t}(a.Component);var b=function(){return i.a.createElement("div",{className:"App"},i.a.createElement("header",{className:"App-header"},i.a.createElement("img",{src:u.a,className:"App-logo",alt:"logo"}),i.a.createElement(j,null),i.a.createElement("hr",null),i.a.createElement(E,null)))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));r.a.render(i.a.createElement(b,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}],[[9,1,2]]]);
//# sourceMappingURL=main.8dcb3815.chunk.js.map