import { useState } from 'react';
import './App.css';
import { Tabs } from './components/Tabs';
import { Info } from './components/Info';

function App() {
  const [tabs, setTabs] = useState([
    {
      name: "Tab 1",
      information: "Tab 1 data"
    }, {
      name: "Tab 2",
      information: "Tab 2 data"
    }, {
      name: "Tab 3",
      information: "Tab 3 data"
    }
  ]);
  const [tabdisplay, setTabDisplay] = useState([]);

  const displayTab = (tabIdx) => {
    const filteredTasks = tabs.filter((tab, idx) => {
      return idx === tabIdx;
    });
    setTabDisplay(filteredTasks);
  };



  return (
    <>
      <div>
        <div style={{ display: "flex" }}>
          {
            tabs.map((tab, idx) => {
              return <Tabs tab={tab} key={idx} index={idx} displayTab={displayTab} />;
            })
          }
        </div>
        <div>
          {
            tabdisplay.map((tab, idx) => {
              return <Info tab={tab} key={idx} />;
            })
          }
        </div>
      </div>
    </>
  );
}

export default App;
