package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;

import com.anylogic.libraries.modules.markup_descriptors.*;
import com.anylogic.libraries.fluid.*;

import java.awt.geom.Arc2D;

public class Main extends Agent
{
  // Parameters

  public 
double  dispenseAmount;

  /**
   * Returns default value for parameter <code>dispenseAmount</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _dispenseAmount_DefaultValue_xjal() {
    final Main self = this;
    return 
200 
;
  }

  public void set_dispenseAmount( double value ) {
    if (value == this.dispenseAmount) {
      return;
    }
    double _oldValue_xjal = this.dispenseAmount;
    this.dispenseAmount = value;
    onChange_dispenseAmount_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter dispenseAmount.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_dispenseAmount()</code> method instead.
   */
  protected void onChange_dispenseAmount() {
    onChange_dispenseAmount_xjal( dispenseAmount );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_dispenseAmount_xjal( double oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    dispenseAmount = _dispenseAmount_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "dispenseAmount":
      if ( _callOnChange_xjal ) {
        set_dispenseAmount( ((Number) _value_xjal).doubleValue() );
      } else {
        dispenseAmount = ((Number) _value_xjal).doubleValue();
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "dispenseAmount": _result_xjal = dispenseAmount; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "dispenseAmount" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 desiredFlowRate;
  public 
double 
 dispensedAmount;
  public 
int 
 numOfPortions;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }




  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _pipeline_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public com.anylogic.libraries.fluid.Valve valve3;
  public com.anylogic.libraries.fluid.FluidSource fluidSource;
  public com.anylogic.libraries.fluid.Tank tank;
  public com.anylogic.libraries.fluid.Pipeline pipeline3;
  public com.anylogic.libraries.fluid.FluidSplit fluidSplit;
  public com.anylogic.libraries.fluid.Pipeline pipeline4;
  public com.anylogic.libraries.fluid.Pipeline pipeline5;
  public com.anylogic.libraries.fluid.Pipeline pipeline6;
  public com.anylogic.libraries.fluid.Pipeline pipeline;
  public com.anylogic.libraries.fluid.Valve valve5;
  public com.anylogic.libraries.fluid.Pipeline pipeline7;

  public String getNameOf( Agent ao ) {
    if ( ao == valve3 ) return "valve3";
    if ( ao == fluidSource ) return "fluidSource";
    if ( ao == tank ) return "tank";
    if ( ao == pipeline3 ) return "pipeline3";
    if ( ao == fluidSplit ) return "fluidSplit";
    if ( ao == pipeline4 ) return "pipeline4";
    if ( ao == pipeline5 ) return "pipeline5";
    if ( ao == pipeline6 ) return "pipeline6";
    if ( ao == pipeline ) return "pipeline";
    if ( ao == valve5 ) return "valve5";
    if ( ao == pipeline7 ) return "pipeline7";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }


  public String getNameOf( AgentList<?> aolist ) {
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }


  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Valve instantiate_valve3_xjal() {
    com.anylogic.libraries.fluid.Valve _result_xjal = new com.anylogic.libraries.fluid.Valve( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_openRate() {
        return CUBIC_METER_PER_SECOND;
      }

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_portionSize() {
        return CUBIC_METER;
      }
      @Override
      public void onPortion( double amount ) {
        _valve3_onPortion_xjal( this, amount );
      }
      @Override
      public void onDispensed( double amount ) {
        _valve3_onDispensed_xjal( this, amount );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_valve3_xjal( final com.anylogic.libraries.fluid.Valve self, TableInput _t ) {
    self.maxOpenRate = self._maxOpenRate_DefaultValue_xjal();
    self.openRate = 
5 
;
    self.closed = self._closed_DefaultValue_xjal();
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
    self.actionOnPortion = 
true 
;
    self.portionSize = 
100 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_valve3_xjal( com.anylogic.libraries.fluid.Valve self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.FluidSource instantiate_fluidSource_xjal() {
    com.anylogic.libraries.fluid.FluidSource _result_xjal = new com.anylogic.libraries.fluid.FluidSource( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_rate() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_fluidSource_xjal( final com.anylogic.libraries.fluid.FluidSource self, TableInput _t ) {
    self.maxRate = self._maxRate_DefaultValue_xjal();
    self.rate = 
20 
;
    self.infiniteCapacity = self._infiniteCapacity_DefaultValue_xjal();
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.modeBatchCustom = self._modeBatchCustom_DefaultValue_xjal();
    self.customBatch = self._customBatch_DefaultValue_xjal();
    self.customBatchColor = self._customBatchColor_DefaultValue_xjal();
    self.storageTank = self._storageTank_DefaultValue_xjal();
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_fluidSource_xjal( com.anylogic.libraries.fluid.FluidSource self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Tank instantiate_tank_xjal() {
    com.anylogic.libraries.fluid.Tank _result_xjal = new com.anylogic.libraries.fluid.Tank( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_initialAmount() {
        return CUBIC_METER;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_tank_xjal( final com.anylogic.libraries.fluid.Tank self, TableInput _t ) {
    self.capacity = self._capacity_DefaultValue_xjal();
    self.initialAmount = 
0 
;
    self.limitRateOut = self._limitRateOut_DefaultValue_xjal();
    self.maxRateOut = self._maxRateOut_DefaultValue_xjal();
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = self._customInitialBatch_DefaultValue_xjal();
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = self._customInitialBatchColor_DefaultValue_xjal();
    self.modeOutputBatch = self._modeOutputBatch_DefaultValue_xjal();
    self.customOutputBatchColor = self._customOutputBatchColor_DefaultValue_xjal();
    self.storageTank = 
storageTank 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
    self.actionOnAbove = self._actionOnAbove_DefaultValue_xjal();
    self.actionOnBelow = self._actionOnBelow_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_tank_xjal( com.anylogic.libraries.fluid.Tank self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Pipeline instantiate_pipeline3_xjal() {
    com.anylogic.libraries.fluid.Pipeline _result_xjal = new com.anylogic.libraries.fluid.Pipeline( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_capacity() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRate() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pipeline3_xjal( final com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
    self.capacity = 
200 
;
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.limitRate = 
true 
;
    self.maxRate = 
200 
;
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = 
true 
;
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = 
true 
;
    self.pipe = 
pipe 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pipeline3_xjal( com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.FluidSplit instantiate_fluidSplit_xjal() {
    com.anylogic.libraries.fluid.FluidSplit _result_xjal = new com.anylogic.libraries.fluid.FluidSplit( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRateOut() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_fluidSplit_xjal( final com.anylogic.libraries.fluid.FluidSplit self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.fraction1 = self._fraction1_DefaultValue_xjal();
    self.fraction2 = self._fraction2_DefaultValue_xjal();
    self.customPriorities = self._customPriorities_DefaultValue_xjal();
    self.priorityOutput1 = self._priorityOutput1_DefaultValue_xjal();
    self.priorityOutput1Custom = self._priorityOutput1Custom_DefaultValue_xjal();
    self.priorityOutput2Custom = self._priorityOutput2Custom_DefaultValue_xjal();
    self.limitRateOut = 
true 
;
    self.maxRateOut = 
200 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_fluidSplit_xjal( com.anylogic.libraries.fluid.FluidSplit self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Pipeline instantiate_pipeline4_xjal() {
    com.anylogic.libraries.fluid.Pipeline _result_xjal = new com.anylogic.libraries.fluid.Pipeline( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_capacity() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRate() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pipeline4_xjal( final com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
    self.capacity = 
200 
;
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.limitRate = 
true 
;
    self.maxRate = 
200 
;
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = 
true 
;
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = 
true 
;
    self.pipe = 
pipe4 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pipeline4_xjal( com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Pipeline instantiate_pipeline5_xjal() {
    com.anylogic.libraries.fluid.Pipeline _result_xjal = new com.anylogic.libraries.fluid.Pipeline( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_capacity() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRate() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pipeline5_xjal( final com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
    self.capacity = 
200 
;
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.limitRate = 
true 
;
    self.maxRate = 
200 
;
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = 
true 
;
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = 
true 
;
    self.pipe = 
pipe6 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pipeline5_xjal( com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Pipeline instantiate_pipeline6_xjal() {
    com.anylogic.libraries.fluid.Pipeline _result_xjal = new com.anylogic.libraries.fluid.Pipeline( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_capacity() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRate() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pipeline6_xjal( final com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
    self.capacity = 
200 
;
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.limitRate = 
true 
;
    self.maxRate = 
200 
;
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = 
true 
;
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = 
true 
;
    self.pipe = 
pipe1 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pipeline6_xjal( com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Pipeline instantiate_pipeline_xjal() {
    com.anylogic.libraries.fluid.Pipeline _result_xjal = new com.anylogic.libraries.fluid.Pipeline( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pipeline_xjal( final com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
    self.capacity = self._capacity_DefaultValue_xjal();
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.limitRate = self._limitRate_DefaultValue_xjal();
    self.maxRate = self._maxRate_DefaultValue_xjal();
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = self._customInitialBatch_DefaultValue_xjal();
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = self._customInitialBatchColor_DefaultValue_xjal();
    self.pipe = 
pipe2 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pipeline_xjal( com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Valve instantiate_valve5_xjal() {
    com.anylogic.libraries.fluid.Valve _result_xjal = new com.anylogic.libraries.fluid.Valve( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_openRate() {
        return CUBIC_METER_PER_SECOND;
      }

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_portionSize() {
        return CUBIC_METER;
      }
      @Override
      public void onPortion( double amount ) {
        _valve5_onPortion_xjal( this, amount );
      }
      @Override
      public void onDispensed( double amount ) {
        _valve5_onDispensed_xjal( this, amount );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_valve5_xjal( final com.anylogic.libraries.fluid.Valve self, TableInput _t ) {
    self.maxOpenRate = self._maxOpenRate_DefaultValue_xjal();
    self.openRate = 
5 
;
    self.closed = self._closed_DefaultValue_xjal();
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
    self.actionOnPortion = 
true 
;
    self.portionSize = 
100 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_valve5_xjal( com.anylogic.libraries.fluid.Valve self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.Pipeline instantiate_pipeline7_xjal() {
    com.anylogic.libraries.fluid.Pipeline _result_xjal = new com.anylogic.libraries.fluid.Pipeline( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_capacity() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRate() {
        return CUBIC_METER_PER_SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pipeline7_xjal( final com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
    self.capacity = 
200 
;
    self.initialAmount = self._initialAmount_DefaultValue_xjal();
    self.limitRate = 
true 
;
    self.maxRate = 
200 
;
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = 
true 
;
    self.initialBatch = self._initialBatch_DefaultValue_xjal();
    self.customInitialBatchColor = 
true 
;
    self.pipe = 
pipe5 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pipeline7_xjal( com.anylogic.libraries.fluid.Pipeline self, TableInput _t ) {
  }

  private void _valve3_onPortion_xjal( final com.anylogic.libraries.fluid.Valve self, double amount ) {
    
numOfPortions++; 
;
  }
  private void _valve3_onDispensed_xjal( final com.anylogic.libraries.fluid.Valve self, double amount ) {
    
dispensedAmount += amount; 
;
  }
  private void _valve5_onPortion_xjal( final com.anylogic.libraries.fluid.Valve self, double amount ) {
    
numOfPortions++; 
;
  }
  private void _valve5_onDispensed_xjal( final com.anylogic.libraries.fluid.Valve self, double amount ) {
    
dispensedAmount += amount; 
;
  }
  // Functions

  
int 
 defaultMode(  ) { 

if (fluidSplit.mode.equals(SplitMergeMode.SPLITMERGE_NEUTRAL))
	return 0;

if (fluidSplit.mode.equals(SplitMergeMode.SPLITMERGE_PROPORTIONAL))
	return 1;
else return 2; 
  }

  public 
String 
 toString(  ) { 

return
	"dispensedAmount = " + dispensedAmount + "\n" +
	"numOfPortions = " + numOfPortions + "\n" +
	"desiredFlowRate = " + desiredFlowRate + "\n" +
	"dispenseAmount = " + dispenseAmount; 
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1160.0, 800.0 );
  @AnyLogicInternalCodegenAPI
  public ViewArea _window3d_VA = new ViewArea( this, "[window3d]", -400.0, 870.0, 1170.0, 830.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
      _output.put( "_window3d_VA", this._window3d_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _checkbox1_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio2_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _radio3_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _editbox4_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _editbox5_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _editbox6_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _editbox7_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _button1_Font = _checkbox1_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = new Font("Dialog", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text14_Font = new Font("SansSerif", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text15_Font = _text14_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text16_Font = _text14_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text17_Font = _text14_Font;
  protected static final Color __ps257_Fill_Color = new Color( 0xFF4F8FC8, true );
  protected static final Color __ps258_Fill_Color = new Color( 0xFFA8C5E5, true );
  protected static final Color __ps259_Fill_Color = new Color( 0xFF7CAAD7, true );
  protected static final Color __ps260_Fill_Color = new Color( 0xFFDEEAF5, true );
  protected static final Color __ps261_Line_Color = new Color( 0xFF1F2B3E, true );
  protected static final Color __ps262_Fill_Color = new Color( 0xFF3C5277, true );
  protected static final Color __ps263_Fill_Color = new Color( 0xFF3C5277, true );
  protected static final Color __ps264_Fill_Color = new Color( 0xFF3C5277, true );
  protected static final Color __ps265_Fill_Color = new Color( 0x50000000, true );
  protected static final Color __ps266_Fill_Color = new Color( 0xFF4F8FC8, true );
  protected static final Color __ps267_Fill_Color = new Color( 0xFFA8C5E5, true );
  protected static final Color __ps268_Fill_Color = new Color( 0xFF7CAAD7, true );
  protected static final Color __ps269_Fill_Color = new Color( 0xFFDEEAF5, true );
  protected static final Color __ps270_Line_Color = new Color( 0xFF1F2B3E, true );
  protected static final Color __ps271_Fill_Color = new Color( 0xFF3C5277, true );
  protected static final Color __ps272_Fill_Color = new Color( 0xFF3C5277, true );
  protected static final Color __ps273_Fill_Color = new Color( 0xFF3C5277, true );
  protected static final Color __ps274_Fill_Color = new Color( 0x50000000, true );
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _pipe_valve1_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_27", null ),
  };
  @AnyLogicInternalCodegenAPI
  protected static final Pair<String, Color>[] _pipe_valve2_customColors_xjal = new Pair[] {
    new Pair<String, Color>( "MA_material_27", null ),
  };
  protected static final Color _pipe4_Line_Color = new Color( 0x40404040, true );
  protected static final Color _pipe_Line_Color = new Color( 0x40404040, true );
  protected static final Color _storageTank_Line_Color = new Color( 0x40404040, true );
  protected static final Color _pipe6_Line_Color = new Color( 0x40404040, true );
  protected static final Color _pipe1_Line_Color = new Color( 0x40404040, true );
  protected static final Color _pipe2_Line_Color = new Color( 0x40404040, true );
  protected static final Color _pipe5_Line_Color = new Color( 0x40404040, true );
  @AnyLogicInternalCodegenAPI
  protected static final int __ps257 = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps258 = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps259 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps260 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps261 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps262 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps263 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps264 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps265 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _house1 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps266 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps267 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps268 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps269 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps270 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps271 = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps272 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps273 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int __ps274 = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _house3 = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = 30;
  @AnyLogicInternalCodegenAPI
  protected static final int _text14 = 31;
  @AnyLogicInternalCodegenAPI
  protected static final int _text15 = 32;
  @AnyLogicInternalCodegenAPI
  protected static final int _customPriorityGroup1 = 33;
  @AnyLogicInternalCodegenAPI
  protected static final int _text16 = 34;
  @AnyLogicInternalCodegenAPI
  protected static final int _text17 = 35;
  @AnyLogicInternalCodegenAPI
  protected static final int _proportionalGroup1 = 36;
  @AnyLogicInternalCodegenAPI
  protected static final int _pipe_valve1 = 37;
  @AnyLogicInternalCodegenAPI
  protected static final int _pipe_valve2 = 38;
  @AnyLogicInternalCodegenAPI
  protected static final int _flowRateSlider = 39;
  @AnyLogicInternalCodegenAPI
  protected static final int _checkbox1 = 40;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio2 = 41;
  @AnyLogicInternalCodegenAPI
  protected static final int _radio3 = 42;
  @AnyLogicInternalCodegenAPI
  protected static final int _editbox4 = 43;
  @AnyLogicInternalCodegenAPI
  protected static final int _editbox5 = 44;
  @AnyLogicInternalCodegenAPI
  protected static final int _editbox6 = 45;
  @AnyLogicInternalCodegenAPI
  protected static final int _editbox7 = 46;
  @AnyLogicInternalCodegenAPI
  protected static final int _button = 47;
  @AnyLogicInternalCodegenAPI
  protected static final int _button1 = 48;
  @AnyLogicInternalCodegenAPI
  protected static final int _window3d = 49;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 50;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps257_pointsDX_xjal() {
    return new double[] { 0.0, 50.714, 50.714, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps257_pointsDY_xjal() {
    return new double[] { 0.0, -25.217, -55.478, -30.261,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps257_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps258_pointsDX_xjal() {
    return new double[] { 0.0, 50.714, 25.357, -25.357,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps258_pointsDY_xjal() {
    return new double[] { 0.0, -25.217, -55.478, -30.261,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps258_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps259_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 25.357, 50.714, 50.714,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps259_pointsDY_xjal() {
    return new double[] { 0.0, -30.261, -35.304, -5.043, 25.217,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps259_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps260_pointsDX_xjal() {
    return new double[] { 0.0, 50.714, 76.071, 25.357,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps260_pointsDY_xjal() {
    return new double[] { 0.0, -25.217, -30.261, -5.043,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps260_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps261_pointsDX_xjal() {
    return new double[] { 0.0, 50.714, 50.714, 25.357, 0.0, -50.714, -50.714,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps261_pointsDY_xjal() {
    return new double[] { 0.0, -25.217, -55.478, -85.739, -80.696, -55.478, -25.217,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps261_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps262_pointsDX_xjal() {
    return new double[] { 0.0, 10.143, 10.143, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps262_pointsDY_xjal() {
    return new double[] { 0.0, 5.043, -10.087, -15.13,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps262_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps263_pointsDX_xjal() {
    return new double[] { 0.0, 10.143, 10.143, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps263_pointsDY_xjal() {
    return new double[] { 0.0, -5.043, -20.174, -15.13,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps263_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps264_pointsDX_xjal() {
    return new double[] { 0.0, 10.143, 10.143, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps264_pointsDY_xjal() {
    return new double[] { 0.0, 5.043, -10.087, -15.13,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps264_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps265_pointsDX_xjal() {
    return new double[] { 0.0, 20.286, 71.0, 50.714,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps265_pointsDY_xjal() {
    return new double[] { 0.0, 10.087, -15.13, -25.217,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps265_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps266_pointsDX_xjal() {
    return new double[] { 0.0, 50.0, 50.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps266_pointsDY_xjal() {
    return new double[] { 0.0, -25.0, -55.0, -30.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps266_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps267_pointsDX_xjal() {
    return new double[] { 0.0, 50.0, 25.0, -2.0, -25.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps267_pointsDY_xjal() {
    return new double[] { 0.0, -25.0, -55.0, -42.0, -30.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps267_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps268_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 25.0, 50.0, 50.0, 50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps268_pointsDY_xjal() {
    return new double[] { 0.0, -30.0, -35.0, -5.0, 14.0, 25.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps268_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps269_pointsDX_xjal() {
    return new double[] { 0.0, 50.0, 75.0, 25.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps269_pointsDY_xjal() {
    return new double[] { 0.0, -25.0, -30.0, -5.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps269_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps270_pointsDX_xjal() {
    return new double[] { 0.0, 50.0, 50.0, 25.0, 0.0, -50.0, -50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps270_pointsDY_xjal() {
    return new double[] { 0.0, -25.0, -55.0, -85.0, -80.0, -55.0, -25.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps270_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps271_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 10.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps271_pointsDY_xjal() {
    return new double[] { 0.0, 5.0, -10.0, -15.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps271_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps272_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 10.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps272_pointsDY_xjal() {
    return new double[] { 0.0, -5.0, -20.0, -15.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps272_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps273_pointsDX_xjal() {
    return new double[] { 0.0, 10.0, 10.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps273_pointsDY_xjal() {
    return new double[] { 0.0, 5.0, -10.0, -15.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps273_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps274_pointsDX_xjal() {
    return new double[] { 0.0, 20.0, 70.0, 50.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps274_pointsDY_xjal() {
    return new double[] { 0.0, 10.0, -15.0, -25.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] __ps274_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(house1, house3, pipe4, pipe, flowRateSlider, text, text1, text2, text3, text4, text5, text6, text7, text8, storageTank, text9, checkbox1, radio2, radio3, customPriorityGroup1, proportionalGroup1, button, button1, window3d, pipe6, pipe1, pipe2, pipe5, pipe_valve1, pipe_valve2);
  }
	@AnyLogicInternalCodegenAPI
	private static MarkupSegment[] _pipe4_segments_xjal() {
	  return new MarkupSegment[] {      
		new MarkupSegmentLine
		(
			300.0, 340.0, 0.0,
			295.0, 340.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			295.0, 340.0, 0.0,
			200.0, 240.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			200.0, 240.0, 0.0,
			170.0, 240.0, 0.0
		),				
	};
  }
	@AnyLogicInternalCodegenAPI
	private static MarkupSegment[] _pipe_segments_xjal() {
	  return new MarkupSegment[] {      
		new MarkupSegmentLine
		(
			-70.0, 400.0, 0.0,
			90.0, 400.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			90.0, 400.0, 0.0,
			150.0, 400.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			150.0, 400.0, 0.0,
			220.0, 410.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			220.0, 410.0, 0.0,
			410.0, 450.0, 0.0
		),				
	};
  }
	@AnyLogicInternalCodegenAPI
	private static MarkupSegment[] _pipe6_segments_xjal() {
	  return new MarkupSegment[] {      
		new MarkupSegmentLine
		(
			170.0, 240.0, 0.0,
			70.0, 235.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			70.0, 235.0, 0.0,
			-200.0, 220.0, 0.0
		),				
	};
  }
	@AnyLogicInternalCodegenAPI
	private static MarkupSegment[] _pipe1_segments_xjal() {
	  return new MarkupSegment[] {      
		new MarkupSegmentLine
		(
			480.0, 430.0, 0.0,
			300.0, 770.0, 0.0
		),				
	};
  }
	@AnyLogicInternalCodegenAPI
	private static MarkupSegment[] _pipe2_segments_xjal() {
	  return new MarkupSegment[] {      
		new MarkupSegmentLine
		(
			410.0, 450.0, 0.0,
			480.0, 430.0, 0.0
		),				
	};
  }
	@AnyLogicInternalCodegenAPI
	private static MarkupSegment[] _pipe5_segments_xjal() {
	  return new MarkupSegment[] {      
		new MarkupSegmentLine
		(
			-70.0, 400.0, 0.0,
			30.0, 350.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			30.0, 350.0, 0.0,
			120.0, 340.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			120.0, 340.0, 0.0,
			220.0, 340.0, 0.0
		),	      
		new MarkupSegmentLine
		(
			220.0, 340.0, 0.0,
			295.0, 340.0, 0.0
		),				
	};
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button: {
          ShapeButton self = this.button;
valve3.toggle(); 
;}
        break;
      case _button1: {
          ShapeButton self = this.button1;
valve5.toggle(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, boolean value ) {
    switch( _shape ) {
      case _checkbox1:
        fluidSplit.set_customPriorities( value );
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, int value ) {
    switch( _shape ) {
      case _radio2: {
          ShapeRadioButtonGroup self = this.radio2;
if(value == 0) fluidSplit.set_mode(SplitMergeMode.SPLITMERGE_NEUTRAL);
else if(value == 1) fluidSplit.set_mode(SplitMergeMode.SPLITMERGE_PROPORTIONAL);
	 else fluidSplit.set_mode(SplitMergeMode.SPLITMERGE_PRIORITY); 
;}
        break;
      case _radio3: {
          ShapeRadioButtonGroup self = this.radio3;
if(value == 0) fluidSplit.set_priorityOutput1(true);
else fluidSplit.set_priorityOutput1(false); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, double value ) {
    switch( _shape ) {
      case _flowRateSlider:
        valve3.set_openRate( value );
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
        

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, String value ) {
    switch( _shape ) {
      case _editbox4:
        fluidSplit.set_priorityOutput1Custom( Integer.parseInt(value) );
        break;
      case _editbox5:
        fluidSplit.set_priorityOutput2Custom( Integer.parseInt(value) );
        break;
      case _editbox6:
        fluidSplit.set_fraction1( Double.parseDouble(value) );
        break;
      case _editbox7:
        fluidSplit.set_fraction2( Double.parseDouble(value) );
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
         
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean getShapeControlDefaultValueBoolean( int _shape, int index ) {
    switch(_shape) {
      case _checkbox1: return 
fluidSplit.customPriorities 
;
      default: return super.getShapeControlDefaultValueBoolean( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getShapeControlDefaultValueInt( int _shape, int index ) {
    switch(_shape) {
      case _radio2: return 
defaultMode() 
;
      default: return super.getShapeControlDefaultValueInt( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _flowRateSlider: return 
valve3.openRate 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getShapeControlDefaultValueString( int _shape, int index ) {
    switch(_shape) {
      case _editbox4: return String.valueOf(
fluidSplit.priorityOutput1Custom 
);
      case _editbox5: return String.valueOf(
fluidSplit.priorityOutput2Custom 
);
      case _editbox6: return String.valueOf(
fluidSplit.fraction1 
);
      case _editbox7: return String.valueOf(
fluidSplit.fraction2 
);
      default: return super.getShapeControlDefaultValueString( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _flowRateSlider_SetDynamicParams_xjal( ShapeSlider shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
1 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
200 ;
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeSlider flowRateSlider;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _checkbox1_SetDynamicParams_xjal( ShapeCheckBox shape ) {
    boolean _visible = 
fluidSplit.mode.equals(SplitMergeMode.SPLITMERGE_PRIORITY) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeCheckBox checkbox1;
  protected ShapeRadioButtonGroup radio2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _radio3_SetDynamicParams_xjal( ShapeRadioButtonGroup shape ) {
    boolean _visible = 
fluidSplit.mode.equals(SplitMergeMode.SPLITMERGE_PRIORITY) && 
!fluidSplit.customPriorities 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeRadioButtonGroup radio3;
  protected ShapeTextField editbox4;
  protected ShapeTextField editbox5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editbox6_SetDynamicParams_xjal( ShapeTextField shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0.01 ;
      @AnyLogicInternalCodegenAPI
      double _max = shape.getMax();
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeTextField editbox6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editbox7_SetDynamicParams_xjal( ShapeTextField shape ) {
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
0.01 ;
      @AnyLogicInternalCodegenAPI
      double _max = shape.getMax();
      shape.setRange( _min, _max );
    }
  }
  
  protected ShapeTextField editbox7;
  protected ShapeButton button;
  protected ShapeButton button1;
  protected ShapeWindow3D window3d;
  protected ShapePolyLine _ps257;
  protected ShapePolyLine _ps258;
  protected ShapePolyLine _ps259;
  protected ShapePolyLine _ps260;
  protected ShapePolyLine _ps261;
  protected ShapePolyLine _ps262;
  protected ShapePolyLine _ps263;
  protected ShapePolyLine _ps264;
  protected ShapePolyLine _ps265;
  protected ShapeGroup house1;
  protected ShapePolyLine _ps266;
  protected ShapePolyLine _ps267;
  protected ShapePolyLine _ps268;
  protected ShapePolyLine _ps269;
  protected ShapePolyLine _ps270;
  protected ShapePolyLine _ps271;
  protected ShapePolyLine _ps272;
  protected ShapePolyLine _ps273;
  protected ShapePolyLine _ps274;
  protected ShapeGroup house3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getMin() 
);
  }
  
  protected ShapeText text;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getMax() 
);
  }
  
  protected ShapeText text1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text2_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getValue() 
);
  }
  
  protected ShapeText text2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getMin() 
);
  }
  
  protected ShapeText text3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text4_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getMax() 
);
  }
  
  protected ShapeText text4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text5_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getValue() 
);
  }
  
  protected ShapeText text5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text6_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getMin() 
);
  }
  
  protected ShapeText text6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text7_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getMax() 
);
  }
  
  protected ShapeText text7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text8_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
flowRateSlider.getValue() 
);
  }
  
  protected ShapeText text8;
  protected ShapeText text9;
  protected ShapeText text14;
  protected ShapeText text15;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _customPriorityGroup1_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
fluidSplit.mode.equals(SplitMergeMode.SPLITMERGE_PRIORITY) && 
fluidSplit.customPriorities 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup customPriorityGroup1;
  protected ShapeText text16;
  protected ShapeText text17;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _proportionalGroup1_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
fluidSplit.mode.equals(SplitMergeMode.SPLITMERGE_PROPORTIONAL) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
 	}
  }
  
  protected ShapeGroup proportionalGroup1;
  protected Shape3DObject pipe_valve1;
  protected Shape3DObject pipe_valve2;
  protected Pipe pipe4;
  protected Pipe pipe;
  protected StorageTank storageTank;
  protected Pipe pipe6;
  protected Pipe pipe1;
  protected Pipe pipe2;
  protected Pipe pipe5;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    flowRateSlider = new ShapeSlider(
		    Main.this, true, 50.0, 710.0, 
			100.0, 30.0,
            true, false,
            1
            , 200
            , 0
            , ShapeControl.TYPE_DOUBLE ) {
      @Override
      public void updateDynamicProperties() {
        _flowRateSlider_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _flowRateSlider, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _flowRateSlider, 0 ), getMax() ) );
      }
    };
    checkbox1 = new ShapeCheckBox(
		Main.this,true,-150.0, 630.0, 
		120.0, 30.0,
            controlDefault, true,
            _checkbox1_Font,
			"Custom priorities" ) {
      @Override
      public void updateDynamicProperties() {
        _checkbox1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _checkbox1, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setSelected( getShapeControlDefaultValueBoolean( _checkbox1, 0 ) );
      }
    };
    radio2 = new ShapeRadioButtonGroup(
		    Main.this, true, -149.0, 505.0, 
			130.0, 70.0,
            controlDefault, true,
            _radio2_Font, true, 
            new String[]{"Neutral mode", "Proportional mode", "Priority mode", } ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _radio2, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( getShapeControlDefaultValueInt( _radio2, 0 ) );
      }
    };
    radio3 = new ShapeRadioButtonGroup(
		    Main.this, true, -150.0, 660.0, 
			140.0, 50.0,
            controlDefault, true,
            _radio3_Font, true, 
            new String[]{"Set priority to output1", "Set priority to output2", } ) {
      @Override
      public void updateDynamicProperties() {
        _radio3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _radio3, 0, value );
      }
    };
    editbox4 = new ShapeTextField(
			Main.this, true,34.0, -26.0, 
			26.0, 20.0,
            controlDefault, controlDefault, true, _editbox4_Font,
            ShapeControl.TYPE_INT, -infinity
            , infinity
			 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _editbox4, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _editbox4, 0 ) );
      }
    };
    editbox5 = new ShapeTextField(
			Main.this, true,34.0, -2.0, 
			26.0, 20.0,
            controlDefault, controlDefault, true, _editbox5_Font,
            ShapeControl.TYPE_INT, -infinity
            , infinity
			 ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _editbox5, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _editbox5, 0 ) );
      }
    };
    editbox6 = new ShapeTextField(
			Main.this, true,66.0, -25.0, 
			26.0, 20.0,
            controlDefault, controlDefault, true, _editbox6_Font,
            ShapeControl.TYPE_DOUBLE, 0.01
            , infinity
			 ) {
      @Override
      public void updateDynamicProperties() {
        _editbox6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _editbox6, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _editbox6, 0 ) );
      }
    };
    editbox7 = new ShapeTextField(
			Main.this, true,66.0, -1.0, 
			26.0, 20.0,
            controlDefault, controlDefault, true, _editbox7_Font,
            ShapeControl.TYPE_DOUBLE, 0.01
            , infinity
			 ) {
      @Override
      public void updateDynamicProperties() {
        _editbox7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _editbox7, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _editbox7, 0 ) );
      }
    };
    button = new ShapeButton(
			Main.this, true, 161.60000000000002, 476.8, 
			100.0, 30.0,
            controlDefault, true,
            _button_Font, 
			"Toggle valve" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button, 0 );
      }
    };
    button1 = new ShapeButton(
			Main.this, true, 40.0, 480.0, 
			100.0, 30.0,
            controlDefault, true,
            _button1_Font, 
			"Toggle valve5" ) {

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _button1, 0 );
      }
    };
    window3d = new ShapeWindow3D( Main.this, false, -400.0, 870.0, 1170.0, 830.0, WINDOW_3D_NAVIGATION_FULL, 2000.0 );
    _ps257 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.071, 50.435, 0.0, null, __ps257_Fill_Color,
            4, __ps257_pointsDX_xjal(), __ps257_pointsDY_xjal(), __ps257_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps258 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.071, 20.174, 0.0, null, __ps258_Fill_Color,
            4, __ps258_pointsDX_xjal(), __ps258_pointsDY_xjal(), __ps258_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps259 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.786, 25.217, 0.0, null, __ps259_Fill_Color,
            5, __ps259_pointsDX_xjal(), __ps259_pointsDY_xjal(), __ps259_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps260 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.786, -5.043, 0.0, null, __ps260_Fill_Color,
            4, __ps260_pointsDX_xjal(), __ps260_pointsDY_xjal(), __ps260_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps261 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.071, 50.435, 0.0, __ps261_Line_Color, null,
            7, __ps261_pointsDX_xjal(), __ps261_pointsDY_xjal(), __ps261_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps262 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -45.643, 20.174, 0.0, null, __ps262_Fill_Color,
            4, __ps262_pointsDX_xjal(), __ps262_pointsDY_xjal(), __ps262_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps263 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, 5.071, 35.304, 0.0, null, __ps263_Fill_Color,
            4, __ps263_pointsDX_xjal(), __ps263_pointsDY_xjal(), __ps263_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps264 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -25.357, 30.261, 0.0, null, __ps264_Fill_Color,
            4, __ps264_pointsDX_xjal(), __ps264_pointsDY_xjal(), __ps264_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps265 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.071, 50.435, 0.0, null, __ps265_Fill_Color,
            4, __ps265_pointsDX_xjal(), __ps265_pointsDY_xjal(), __ps265_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps266 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.0, 50.0, 0.0, null, __ps266_Fill_Color,
            4, __ps266_pointsDX_xjal(), __ps266_pointsDY_xjal(), __ps266_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps267 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.0, 20.0, 0.0, null, __ps267_Fill_Color,
            5, __ps267_pointsDX_xjal(), __ps267_pointsDY_xjal(), __ps267_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps268 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.0, 25.0, 0.0, null, __ps268_Fill_Color,
            6, __ps268_pointsDX_xjal(), __ps268_pointsDY_xjal(), __ps268_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps269 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -55.0, -5.0, 0.0, null, __ps269_Fill_Color,
            4, __ps269_pointsDX_xjal(), __ps269_pointsDY_xjal(), __ps269_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps270 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.0, 50.0, 0.0, __ps270_Line_Color, null,
            7, __ps270_pointsDX_xjal(), __ps270_pointsDY_xjal(), __ps270_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps271 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -45.0, 20.0, 0.0, null, __ps271_Fill_Color,
            4, __ps271_pointsDX_xjal(), __ps271_pointsDY_xjal(), __ps271_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps272 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, 5.0, 35.0, 0.0, null, __ps272_Fill_Color,
            4, __ps272_pointsDX_xjal(), __ps272_pointsDY_xjal(), __ps272_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps273 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -25.0, 30.0, 0.0, null, __ps273_Fill_Color,
            4, __ps273_pointsDX_xjal(), __ps273_pointsDY_xjal(), __ps273_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    _ps274 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -5.0, 50.0, 0.0, null, __ps274_Fill_Color,
            4, __ps274_pointsDX_xjal(), __ps274_pointsDY_xjal(), __ps274_pointsDZ_xjal(), true, 10.0, 1.0, LINE_STYLE_SOLID );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 740.0, 0.0, 0.0, 
        black,"min",
        _text_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, 740.0, 0.0, 0.0, 
        black,"max",
        _text1_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties() {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,100.0, 740.0, 0.0, 0.0, 
        black,"value",
        _text2_Font, ALIGNMENT_CENTER ) {
      @Override
      public void updateDynamicProperties() {
        _text2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 740.0, 0.0, 0.0, 
        black,"min",
        _text3_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, 740.0, 0.0, 0.0, 
        black,"max",
        _text4_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties() {
        _text4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,100.0, 740.0, 0.0, 0.0, 
        black,"value",
        _text5_Font, ALIGNMENT_CENTER ) {
      @Override
      public void updateDynamicProperties() {
        _text5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 740.0, 0.0, 0.0, 
        black,"min",
        _text6_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text7 = new ShapeText(
        SHAPE_DRAW_2D, true,150.0, 740.0, 0.0, 0.0, 
        black,"max",
        _text7_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties() {
        _text7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text8 = new ShapeText(
        SHAPE_DRAW_2D, true,100.0, 740.0, 0.0, 0.0, 
        black,"value",
        _text8_Font, ALIGNMENT_CENTER ) {
      @Override
      public void updateDynamicProperties() {
        _text8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    text9 = new ShapeText(
        SHAPE_DRAW_2D, true,99.0, 412.0, 0.0, 0.0, 
        black,"Mode:",
        _text9_Font, ALIGNMENT_LEFT );
    text14 = new ShapeText(
        SHAPE_DRAW_2D, true,-65.0, 1.0, 0.0, 0.0, 
        black,"Priority of output2:",
        _text14_Font, ALIGNMENT_LEFT );
    text15 = new ShapeText(
        SHAPE_DRAW_2D, true,-65.0, -22.0, 0.0, 0.0, 
        black,"Priority of output1:",
        _text15_Font, ALIGNMENT_LEFT );
    text16 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, -21.0, 0.0, 0.0, 
        black,"Fraction of output1:",
        _text16_Font, ALIGNMENT_LEFT );
    text17 = new ShapeText(
        SHAPE_DRAW_2D, true,-40.0, 2.0, 0.0, 0.0, 
        black,"Fraction of output2:",
        _text17_Font, ALIGNMENT_LEFT );
    pipe_valve1 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 120.0, 340.0, 0.0, 0.0,
			13.2, true, "/model/",
			"3d/pipe_valve.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -24.0, -26.0,
			54.0, 54.0, null, _pipe_valve1_customColors_xjal );
    pipe_valve2 = new Shape3DObject(
		Main.this, SHAPE_DRAW_2D3D, true, 300.0, 420.0, 0.0, 0.0,
			13.2, true, "/model/",
			"3d/pipe_valve.dae", OBJECT_3D_XYZ_AXIS_ORDER, Object3DInternalLighting.OBJECT_3D_INTERNAL_LIGHTING_OFF, false, -24.0, -26.0,
			54.0, 54.0, null, _pipe_valve2_customColors_xjal );
	pipe4 = new Pipe
	(
			this, SHAPE_DRAW_2D3D, true, 8.0, _pipe4_Line_Color, 
			_pipe4_segments_xjal()
			 );
	pipe = new Pipe
	(
			this, SHAPE_DRAW_2D3D, true, 8.0, _pipe_Line_Color, 
			_pipe_segments_xjal()
			 );
	storageTank = new StorageTank
	(
			this, SHAPE_DRAW_2D3D, true,
			-85.0, 380.0, 0.0,
			90.0, 100.0, _storageTank_Line_Color
			 );
	pipe6 = new Pipe
	(
			this, SHAPE_DRAW_2D3D, true, 8.0, _pipe6_Line_Color, 
			_pipe6_segments_xjal()
			 );
	pipe1 = new Pipe
	(
			this, SHAPE_DRAW_2D3D, true, 8.0, _pipe1_Line_Color, 
			_pipe1_segments_xjal()
			 );
	pipe2 = new Pipe
	(
			this, SHAPE_DRAW_2D3D, true, 8.0, _pipe2_Line_Color, 
			_pipe2_segments_xjal()
			 );
	pipe5 = new Pipe
	(
			this, SHAPE_DRAW_2D3D, true, 8.0, _pipe5_Line_Color, 
			_pipe5_segments_xjal()
			 );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    house1 = new ShapeGroup( Main.this, SHAPE_DRAW_2D3D, true, -230.0, 200.0, 0.0, 0.0
	
	     , _ps257
	     , _ps258
	     , _ps259
	     , _ps260
	     , _ps261
	     , _ps262
	     , _ps263
	     , _ps264
	     , _ps265 );
    }
    {
    house3 = new ShapeGroup( Main.this, SHAPE_DRAW_2D3D, true, 300.0, 770.0, 0.0, 0.0
	
	     , _ps266
	     , _ps267
	     , _ps268
	     , _ps269
	     , _ps270
	     , _ps271
	     , _ps272
	     , _ps273
	     , _ps274 );
    }
    {
    customPriorityGroup1 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, -80.0, 737.0, 0.0, 0.0
	
	     , text14
	     , text15
	     , editbox4
	     , editbox5 ) {
      @Override
      public void updateDynamicProperties() {
        _customPriorityGroup1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    }
    {
    proportionalGroup1 = new ShapeGroup( Main.this, SHAPE_DRAW_2D, true, -104.0, 607.0, 0.0, 0.0
	
	     , text16
	     , text17
	     , editbox6
	     , editbox7 ) {
      @Override
      public void updateDynamicProperties() {
        _proportionalGroup1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };
    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }


  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	

  // Ports

  public Port< 
Object 
, 
Object > port = new Port<>( this );
  public Port< 
Object 
, 
Object > port1 = new Port<>( this );

  @AnyLogicInternalCodegenAPI
  public String getNameOf( Port<?, ?> _p ) {
    if( _p == this.port ) return "port";
    if( _p == this.port1 ) return "port1";
    return super.getNameOf( _p ); 
  }


  /**
   * Constructor
   */
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    valve3 = instantiate_valve3_xjal();
    fluidSource = instantiate_fluidSource_xjal();
    tank = instantiate_tank_xjal();
    pipeline3 = instantiate_pipeline3_xjal();
    fluidSplit = instantiate_fluidSplit_xjal();
    pipeline4 = instantiate_pipeline4_xjal();
    pipeline5 = instantiate_pipeline5_xjal();
    pipeline6 = instantiate_pipeline6_xjal();
    pipeline = instantiate_pipeline_xjal();
    valve5 = instantiate_valve5_xjal();
    pipeline7 = instantiate_pipeline7_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Main() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function.
   */
  public Main( double dispenseAmount ) {
    markParametersAreSet();
    this.dispenseAmount = dispenseAmount;
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level, 
      // default light
      new Light3D.Daylight( null, false, true ) );
    window3d.setCamera( new Camera3D( 144, 674, 300, 0.7853981633974483, -1.5707963267948966 ), false );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "model.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( -200.0, 220.0 );
    // Creating non-replicated embedded objects
    setupParameters_valve3_xjal( valve3, null );
    doBeforeCreate_valve3_xjal( valve3, null );
    valve3.createAsEmbedded();
    setupParameters_fluidSource_xjal( fluidSource, null );
    doBeforeCreate_fluidSource_xjal( fluidSource, null );
    fluidSource.createAsEmbedded();
    setupParameters_tank_xjal( tank, null );
    doBeforeCreate_tank_xjal( tank, null );
    tank.createAsEmbedded();
    setupParameters_pipeline3_xjal( pipeline3, null );
    doBeforeCreate_pipeline3_xjal( pipeline3, null );
    pipeline3.createAsEmbedded();
    setupParameters_fluidSplit_xjal( fluidSplit, null );
    doBeforeCreate_fluidSplit_xjal( fluidSplit, null );
    fluidSplit.createAsEmbedded();
    setupParameters_pipeline4_xjal( pipeline4, null );
    doBeforeCreate_pipeline4_xjal( pipeline4, null );
    pipeline4.createAsEmbedded();
    setupParameters_pipeline5_xjal( pipeline5, null );
    doBeforeCreate_pipeline5_xjal( pipeline5, null );
    pipeline5.createAsEmbedded();
    setupParameters_pipeline6_xjal( pipeline6, null );
    doBeforeCreate_pipeline6_xjal( pipeline6, null );
    pipeline6.createAsEmbedded();
    setupParameters_pipeline_xjal( pipeline, null );
    doBeforeCreate_pipeline_xjal( pipeline, null );
    pipeline.createAsEmbedded();
    setupParameters_valve5_xjal( valve5, null );
    doBeforeCreate_valve5_xjal( valve5, null );
    valve5.createAsEmbedded();
    setupParameters_pipeline7_xjal( pipeline7, null );
    doBeforeCreate_pipeline7_xjal( pipeline7, null );
    pipeline7.createAsEmbedded();
	 // Port connectors with non-replicated objects
    fluidSource.out.connect( tank.in ); // connector1
    pipeline3.out.connect( valve3.in ); // connector3
    fluidSplit.out2.connect( pipeline3.in ); // connector5
    fluidSplit.in.connect( tank.out ); // connector
    pipeline5.in.connect( pipeline4.out ); // connector4
    port.map( pipeline5.out ); // connector11
    pipeline.in.connect( valve3.out ); // connector7
    port1.map( pipeline6.out ); // connector10
    pipeline.out.connect( pipeline6.in ); // connector12
    valve5.out.connect( pipeline4.in ); // connector13
    pipeline7.out.connect( valve5.in ); // connector9
    pipeline7.in.connect( fluidSplit.out1 ); // connector2
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    flowRateSlider.setValueToDefault();
    checkbox1.setValueToDefault();
    radio2.setValueToDefault();
    editbox4.setValueToDefault();
    editbox5.setValueToDefault();
    editbox6.setValueToDefault();
    editbox7.setValueToDefault();
  }

  @AnyLogicInternalCodegenAPI
  public void setupExt_xjal(AgentExtension _ext) {
    // Agent properties setup
    if ( _ext instanceof ExtAgentWithSpatialMetrics && _ext instanceof ExtWithSpaceType && !(tryExt(ExtAgentWithSpatialMetrics.class) instanceof ExtWithSpaceType) ) {
      double _speed;
      _speed = 
50 
;
      ((ExtAgentWithSpatialMetrics) _ext).setSpeed( _speed, MPS );
    }
    if ( _ext instanceof ExtAgentWithSpatialMetrics && tryExt(ExtAgentWithSpatialMetrics.class) == null ) {
      ExtAgentWithSpatialMetrics _e = (ExtAgentWithSpatialMetrics) _ext;
      _e.setAutomaticHorizontalRotation( false );
    }
    if ( _ext instanceof ExtAgentContinuous && tryExt(ExtAgentContinuous.class) == null ) {
      ExtAgentContinuous _e = (ExtAgentContinuous) _ext;
      _e.setAutomaticVerticalRotation( true );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    valve3.startAsEmbedded();
    fluidSource.startAsEmbedded();
    tank.startAsEmbedded();
    pipeline3.startAsEmbedded();
    fluidSplit.startAsEmbedded();
    pipeline4.startAsEmbedded();
    pipeline5.startAsEmbedded();
    pipeline6.startAsEmbedded();
    pipeline.startAsEmbedded();
    valve5.startAsEmbedded();
    pipeline7.startAsEmbedded();
  }
 

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
    dispensedAmount = 
0 
;
    numOfPortions = 
0 
;
  }

  // User API -----------------------------------------------------
  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( valve3 );
    list.add( fluidSource );
    list.add( tank );
    list.add( pipeline3 );
    list.add( fluidSplit );
    list.add( pipeline4 );
    list.add( pipeline5 );
    list.add( pipeline6 );
    list.add( pipeline );
    list.add( valve5 );
    list.add( pipeline7 );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    port.onDestroy();
    port1.onDestroy();
    valve3.onDestroy();
    fluidSource.onDestroy();
    tank.onDestroy();
    pipeline3.onDestroy();
    fluidSplit.onDestroy();
    pipeline4.onDestroy();
    pipeline5.onDestroy();
    pipeline6.onDestroy();
    pipeline.onDestroy();
    valve5.onDestroy();
    pipeline7.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    valve3.doFinish();
    fluidSource.doFinish();
    tank.doFinish();
    pipeline3.doFinish();
    fluidSplit.doFinish();
    pipeline4.doFinish();
    pipeline5.doFinish();
    pipeline6.doFinish();
    pipeline.doFinish();
    valve5.doFinish();
    pipeline7.doFinish();
  }


}
