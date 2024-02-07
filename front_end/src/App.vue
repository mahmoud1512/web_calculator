<template>
  <div id="calculator">
    <div id="display">
      <span>{{ displayContent }}</span>
    </div>

    <div id="buttons">
      <div id="first">
        <button @click="percent()" id="percent">%</button>
        <button @click="CE()" id="CE">CE</button>
        <button @click="c()" id="C">C</button>
        <button @click="del()" id="delete">&#9003;</button>
      </div>
      <div id="second">
        <button @click="inverse()" id="inverse">1/x</button>
        <button @click="pow2()" id="pow2">x<sup>2</sup></button>
        <button @click="square()" id="square">&radic;x</button>
        <button @click="divide()" id="divide">&divide;</button>
      </div>
      <div id="third">
        <button @click="h7()">7</button>
        <button @click="h8()">8</button>
        <button @click="h9()">9</button>
        <button @click="mul()">&times;</button>
      </div>
      <div id="fourth">
        <button @click="h4()">4</button>
        <button @click="h5()">5</button>
        <button @click="h6()">6</button>
        <button @click="sub()">&ndash;</button>
      </div>
      <div id="fifth">
        <button @click="h1()">1</button>
        <button @click="h2()">2</button>
        <button @click="h3()">3</button>
        <button @click="add()">+</button>
      </div>
      <div id="sixth">
        <button @click="neg()">+/-</button>
        <button @click="h0()">0</button>
        <button @click="decimal()">.</button>
        <button @click="equal()" id="equal">=</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "App",
  data() {
    return {
      displayContent: "0",
      op1: 0,
      op: "",
      op2: 0,
      Ac: 0,
      count: 1,
      z: 0,
    };
  },
  methods: {
    Display(String) {
      if(this.displayContent==="E")
      {
        this.c();
      }
      if (this.displayContent === "0") {
        this.displayContent = String;
      }
      else {
        this.displayContent += String;
      }
    },
    h0() {
      if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="0";
      }
     
    },
    h1() {
        if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="1";
      }
     
    },
    h2() {
       if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="2";
      }
     
    },
    h3() {
        if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="3";
      }
     
    },
    h4() {
      if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="4";
      }
     
    },
    h5() {
        if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="5";
      }
     
    },
    h6() {
       if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="6";
      }
     
    },
    h7() {
       if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="7";
      }
     
    },
    h8() {
        if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="8";
      }
     
    },
    h9() {
       if(this.z===0)
      {
           if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+="9";
      }
     
    },
    decimal() {
      if(this.displayContent!=="E")
      {
            let y = 0;
          for (let i = 0; i < this.displayContent.length; i++) {
            if (this.displayContent.charAt(i) === ".") {
              y = 1;
            }
          }
          if(this.z===0)
            this.displayContent += ".";
      }
     
     
    },
    del() {
      if(this.displayContent!=="E")
     {  if(this.z===0)
          {
              let dd = "";
          for (let i = 0; i < this.displayContent.length - 1; i++) {
            dd = dd + this.displayContent[i];
          }
          if (dd === "" || dd === "-" || dd === "-0") {
            this.displayContent = "0";
          } else this.displayContent = dd;
          }
      }
    
    },
    c() {
      this.displayContent = "0";
      this.op1 = 0;
      this.op = "";
      this.op2 = 0;
      this.Ac = 0;
      this.count = 1;
      this.z = 0;
    },
    CE() {
      this.displayContent = "0";
      this.op1 = 0;
      this.op = "";
      this.op2 = 0;
      this.Ac = 0;
      this.count = 1;
      this.z = 0;
    },
    neg() {
       if(this.displayContent!=="E"&&this.z===0)
      {
                 if(this.displayContent==="0")
      {
        this.displayContent="";
      }
        this.displayContent+=" -";
      }
     
    },

    add() {
        if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+="+";
      }

    
    },

    sub() {

        if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+="\u2013";
      }

    },
    mul() {
       if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+="*";
      }

    },
    divide() {

          if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+="/";
      }

    },
    percent() {
        if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+="%";
      }

    },
    inverse() {
        if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+=" Inv";
      }

    },
    pow2() {
         if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+=" pow(2)";
      }


    },
    square() {
        if(this.displayContent!=="E")
      {
           this.z=0;
    this.displayContent+=" pow(0.5)";
      }

    },
    equal() {
      console.log(typeof this.displayContent);
      let q=this.displayContent;
          q = q.replace(/\+/g, "add");
          q = q.replace("\u2013", "sub");
          q = q.replace(/\*/g, "multiply");
          q = q.replace(/\//g, "div");
        this.z=1;  

      axios
        .post('http://localhost:8081/calculate', {
          expression:q
        })
        .then((response)=>{
          this.displayContent=response.data.toString();
          console.log(response.data);
        })
        .catch( (error)=>{
          console.log(error);
        });
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#calculator {
  margin-top: 50px;
  margin-left: 25%;
  margin-right: 25%;
  height: auto;
  width: 50%;
  border: 2px solid;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}
#buttons {
  height: 450px;
  width: 100%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

#equal {
  background-color: aqua;
}
#display {
  height: 150px;
  width: 100%;
  border: 1px solid;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  text-align: right;
}
span {
  margin-top: 50%;
  font-size: 1.7em;
}

#first {
  display: flex;
  justify-content: space-between;
  height: 75px;
}
#second {
  display: flex;
  justify-content: space-between;
  height: 75px;
}
#third {
  display: flex;
  justify-content: space-between;
  height: 75px;
}
#fourth {
  display: flex;
  justify-content: space-between;
  height: 75px;
}
#fifth {
  display: flex;
  justify-content: space-between;
  height: 75px;
}
#sixth {
  display: flex;
  justify-content: space-between;
  height: 75px;
}
button {
  width: 25%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
button:hover {
  opacity: 0.5;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
}
</style>
