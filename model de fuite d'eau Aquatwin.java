package fluidenter_fluidexit;

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

import com.anylogic.libraries.fluid.*;
import com.anylogic.libraries.modules.markup_descriptors.*;

import java.awt.geom.Arc2D;

public class Main extends Agent
{
  // Parameters
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

  public com.anylogic.libraries.fluid.Tank fluidSource2;
  public com.anylogic.libraries.fluid.FluidExit fluidExit2;
  public com.anylogic.libraries.fluid.FluidEnter fluidEnter;
  public com.anylogic.libraries.fluid.FluidDispose fluidDispose;

  public String getNameOf( Agent ao ) {
    if ( ao == fluidSource2 ) return "fluidSource2";
    if ( ao == fluidExit2 ) return "fluidExit2";
    if ( ao == fluidEnter ) return "fluidEnter";
    if ( ao == fluidDispose ) return "fluidDispose";
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
  protected com.anylogic.libraries.fluid.Tank instantiate_fluidSource2_xjal() {
    com.anylogic.libraries.fluid.Tank _result_xjal = new com.anylogic.libraries.fluid.Tank( getEngine(), this, null ) {

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_capacity() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public AmountUnits getUnitsForCodeOf_initialAmount() {
        return CUBIC_METER;
      }

      @AnyLogicInternalCodegenAPI
      public FlowRateUnits getUnitsForCodeOf_maxRateOut() {
        return CUBIC_METER_PER_SECOND;
      }
      @Override
      public Color initialBatchColor( Object batch ) {
        return _fluidSource2_initialBatchColor_xjal( this, batch );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_fluidSource2_xjal( final com.anylogic.libraries.fluid.Tank self, TableInput _t ) {
    self.capacity = 
1000 
;
    self.initialAmount = 
1000 
;
    self.limitRateOut = 
true 
;
    self.maxRateOut = 
10 
;
    self.customPriority = self._customPriority_DefaultValue_xjal();
    self.priorityOutCustom = self._priorityOutCustom_DefaultValue_xjal();
    self.customInitialBatch = 
true 
;
    self.initialBatch = 
"A" 
;
    self.customInitialBatchColor = 
true 
;
    self.modeOutputBatch = self._modeOutputBatch_DefaultValue_xjal();
    self.customOutputBatchColor = self._customOutputBatchColor_DefaultValue_xjal();
    self.storageTank = self._storageTank_DefaultValue_xjal();
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
    self.actionOnAbove = self._actionOnAbove_DefaultValue_xjal();
    self.actionOnBelow = self._actionOnBelow_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_fluidSource2_xjal( com.anylogic.libraries.fluid.Tank self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.FluidExit instantiate_fluidExit2_xjal() {
    com.anylogic.libraries.fluid.FluidExit _result_xjal = new com.anylogic.libraries.fluid.FluidExit( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_fluidExit2_xjal( final com.anylogic.libraries.fluid.FluidExit self, TableInput _t ) {
    self.fluidEnter = 
fluidEnter 
;
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_fluidExit2_xjal( com.anylogic.libraries.fluid.FluidExit self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.FluidEnter instantiate_fluidEnter_xjal() {
    com.anylogic.libraries.fluid.FluidEnter _result_xjal = new com.anylogic.libraries.fluid.FluidEnter( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_fluidEnter_xjal( final com.anylogic.libraries.fluid.FluidEnter self, TableInput _t ) {
    self.limitRateOut = self._limitRateOut_DefaultValue_xjal();
    self.maxRateOut = self._maxRateOut_DefaultValue_xjal();
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_fluidEnter_xjal( com.anylogic.libraries.fluid.FluidEnter self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.fluid.FluidDispose instantiate_fluidDispose_xjal() {
    com.anylogic.libraries.fluid.FluidDispose _result_xjal = new com.anylogic.libraries.fluid.FluidDispose( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_fluidDispose_xjal( final com.anylogic.libraries.fluid.FluidDispose self, TableInput _t ) {
    self.showBatchesInFlowchart = self._showBatchesInFlowchart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_fluidDispose_xjal( com.anylogic.libraries.fluid.FluidDispose self, TableInput _t ) {
  }

  private Color _fluidSource2_initialBatchColor_xjal( final com.anylogic.libraries.fluid.Tank self, Object batch ) {
    Color _value;
    _value = 
crimson 
;
    return _value;
  }
private double _datasetUpdateTime_xjal() {
	return time();
}
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("Dialog", 0, 14 );
  protected static final Color _rectangle_Fill_Color = new Color( 0x64FFFACD, true );
  protected static final Color _rectangle_Line_Color = new Color( 0x64FFFACD, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 2;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 3;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rectangle, text);
  }

  protected ShapeRectangle rectangle;
  protected ShapeText text;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,20.0, 20.0, 0.0, 0.0, 
            _rectangle_Line_Color, _rectangle_Fill_Color,
			460.0, 490.0, 10.0, 1.0, LINE_STYLE_SOLID );
    text = new ShapeText(
        SHAPE_DRAW_2D, true,50.0, 40.0, 0.0, 0.0, 
        black,"Case 1: exemple de fuite d'eau",
        _text_Font, ALIGNMENT_LEFT );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
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
    fluidSource2 = instantiate_fluidSource2_xjal();
    fluidExit2 = instantiate_fluidExit2_xjal();
    fluidEnter = instantiate_fluidEnter_xjal();
    fluidDispose = instantiate_fluidDispose_xjal();
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
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "fluidenter_fluidexit.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Creating non-replicated embedded objects
    setupParameters_fluidSource2_xjal( fluidSource2, null );
    doBeforeCreate_fluidSource2_xjal( fluidSource2, null );
    fluidSource2.createAsEmbedded();
    setupParameters_fluidExit2_xjal( fluidExit2, null );
    doBeforeCreate_fluidExit2_xjal( fluidExit2, null );
    fluidExit2.createAsEmbedded();
    setupParameters_fluidEnter_xjal( fluidEnter, null );
    doBeforeCreate_fluidEnter_xjal( fluidEnter, null );
    fluidEnter.createAsEmbedded();
    setupParameters_fluidDispose_xjal( fluidDispose, null );
    doBeforeCreate_fluidDispose_xjal( fluidDispose, null );
    fluidDispose.createAsEmbedded();
	 // Port connectors with non-replicated objects
    fluidSource2.out.connect( fluidExit2.in ); // connector1
    fluidDispose.in.connect( fluidEnter.out ); // connector3
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    fluidSource2.startAsEmbedded();
    fluidExit2.startAsEmbedded();
    fluidEnter.startAsEmbedded();
    fluidDispose.startAsEmbedded();
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
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<>();
    }
    list.add( fluidSource2 );
    list.add( fluidExit2 );
    list.add( fluidEnter );
    list.add( fluidDispose );
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
    fluidSource2.onDestroy();
    fluidExit2.onDestroy();
    fluidEnter.onDestroy();
    fluidDispose.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    fluidSource2.doFinish();
    fluidExit2.doFinish();
    fluidEnter.doFinish();
    fluidDispose.doFinish();
  }


}
s