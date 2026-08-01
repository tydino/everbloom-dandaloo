package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;

// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BrachiosaurusFullGrownAdultModel extends EntityModel<BrachiosaurusRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("everbloomdandaloo", "brachiosaurus"), "main");

	private final ModelPart root;
	private final ModelPart butt;
	private final ModelPart tailbase;
	private final ModelPart tailmiddle;
	private final ModelPart tailmiddletip;
	private final ModelPart tailtip;
	private final ModelPart chest;
	private final ModelPart neckbase;
	private final ModelPart nackmiddle;
	private final ModelPart neck_tip;
	private final ModelPart headlead;
	private final ModelPart head;
	private final ModelPart bottomjaw;
	private final ModelPart eyelids;
	private final ModelPart frontleftfoot;
	private final ModelPart frontleftshin;
	private final ModelPart frontleftknee;
	private final ModelPart frontleftthigh;
	private final ModelPart frontrightfoot;
	private final ModelPart frontrightshin;
	private final ModelPart frontrightknee;
	private final ModelPart frontrightthigh;
	private final ModelPart backleftfoot;
	private final ModelPart backleftshin;
	private final ModelPart backleftthigh;
	private final ModelPart backrightfoot;
	private final ModelPart backrightshin;
	private final ModelPart backrightthigh;

	final KeyframeAnimation idle;
	final KeyframeAnimation eat;
	final KeyframeAnimation walk;
	final KeyframeAnimation sitDown;
	final KeyframeAnimation sitting;
	final KeyframeAnimation standUp;
	final KeyframeAnimation blinking;

	final KeyframeAnimation leanOver;

	public BrachiosaurusFullGrownAdultModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.butt = this.root.getChild("butt");
		this.tailbase = this.butt.getChild("tailbase");
		this.tailmiddle = this.tailbase.getChild("tailmiddle");
		this.tailmiddletip = this.tailmiddle.getChild("tailmiddletip");
		this.tailtip = this.tailmiddletip.getChild("tailtip");
		this.chest = this.butt.getChild("chest");
		this.neckbase = this.chest.getChild("neckbase");
		this.nackmiddle = this.neckbase.getChild("nackmiddle");
		this.neck_tip = this.nackmiddle.getChild("neck_tip");
		this.headlead = this.neck_tip.getChild("headlead");
		this.head = this.headlead.getChild("head");
		this.bottomjaw = this.head.getChild("bottomjaw");
		this.eyelids = this.head.getChild("eyelids");
		this.frontleftfoot = this.root.getChild("frontleftfoot");
		this.frontleftshin = this.frontleftfoot.getChild("frontleftshin");
		this.frontleftknee = this.frontleftshin.getChild("frontleftknee");
		this.frontleftthigh = this.frontleftknee.getChild("frontleftthigh");
		this.frontrightfoot = this.root.getChild("frontrightfoot");
		this.frontrightshin = this.frontrightfoot.getChild("frontrightshin");
		this.frontrightknee = this.frontrightshin.getChild("frontrightknee");
		this.frontrightthigh = this.frontrightknee.getChild("frontrightthigh");
		this.backleftfoot = this.root.getChild("backleftfoot");
		this.backleftshin = this.backleftfoot.getChild("backleftshin");
		this.backleftthigh = this.backleftshin.getChild("backleftthigh");
		this.backrightfoot = this.root.getChild("backrightfoot");
		this.backrightshin = this.backrightfoot.getChild("backrightshin");
		this.backrightthigh = this.backrightshin.getChild("backrightthigh");

		this.idle = BrachiosaurusFullGrownAdultAnimations.idle.bake(root);
		this.eat = BrachiosaurusFullGrownAdultAnimations.eating.bake(root);
		this.walk = BrachiosaurusFullGrownAdultAnimations.walking.bake(root);
		this.sitDown = BrachiosaurusFullGrownAdultAnimations.sittingdown.bake(root);
		this.sitting = BrachiosaurusFullGrownAdultAnimations.sitting.bake(root);
		this.standUp = BrachiosaurusFullGrownAdultAnimations.standingup.bake(root);
		this.blinking = BrachiosaurusFullGrownAdultAnimations.blinking.bake(root);

		this.leanOver = BrachiosaurusFullGrownAdultAnimations.leandown.bake(root);
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition butt = root.addOrReplaceChild("butt", CubeListBuilder.create(), PartPose.offset(0.0F, -64.0F, 48.0F));

		PartDefinition butt_r1 = butt.addOrReplaceChild("butt_r1", CubeListBuilder.create().texOffs(0, 100).addBox(-47.0F, -48.0F, -48.0F, 48.0F, 48.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0F, 16.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition tailbase = butt.addOrReplaceChild("tailbase", CubeListBuilder.create().texOffs(168, 48).addBox(-16.0F, -16.0F, -1.0F, 32.0F, 32.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 16.0F));

		PartDefinition tailmiddle = tailbase.addOrReplaceChild("tailmiddle", CubeListBuilder.create().texOffs(72, 0).addBox(-8.0F, -12.0F, -1.0F, 16.0F, 16.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 15.0F));

		PartDefinition tail_middle_fin_r1 = tailmiddle.addOrReplaceChild("tail middle fin_r1", CubeListBuilder.create().texOffs(184, 0).addBox(-4.0F, -8.0F, -1.0F, 4.0F, 8.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 11.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tailmiddletip = tailmiddle.addOrReplaceChild("tailmiddletip", CubeListBuilder.create().texOffs(0, 40).addBox(-6.0F, -6.0F, -1.0F, 12.0F, 12.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 39.0F));

		PartDefinition tailtip = tailmiddletip.addOrReplaceChild("tailtip", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 45.0F));

		PartDefinition chest = butt.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, -32.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition chest_r1 = chest.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(4, 212).addBox(-30.0F, -56.0F, -48.0F, 60.0F, 64.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 32.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition neckbase = chest.addOrReplaceChild("neckbase", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -36.0F));

		PartDefinition neck_base_r1 = neckbase.addOrReplaceChild("neck base_r1", CubeListBuilder.create().texOffs(224, 98).addBox(-20.0F, -24.0F, -28.0F, 40.0F, 48.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition nackmiddle = neckbase.addOrReplaceChild("nackmiddle", CubeListBuilder.create().texOffs(280, 178).addBox(-10.0F, -80.0F, -17.0F, 20.0F, 96.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, -19.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition neck_tip = nackmiddle.addOrReplaceChild("neck_tip", CubeListBuilder.create().texOffs(272, 0).addBox(-5.0F, -80.0F, -5.0F, 10.0F, 84.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -79.0F, -5.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition headlead = neck_tip.addOrReplaceChild("headlead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -75.0F, -4.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = headlead.addOrReplaceChild("head", CubeListBuilder.create().texOffs(176, 16).addBox(-6.0F, -6.0F, -12.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top_jaw_r1 = head.addOrReplaceChild("top jaw_r1", CubeListBuilder.create().texOffs(144, 0).addBox(-5.0F, -6.0F, -1.0F, 10.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -18.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(146, 15).addBox(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -11.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bottomjaw = head.addOrReplaceChild("bottomjaw", CubeListBuilder.create().texOffs(144, 29).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -10.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition eyelids = head.addOrReplaceChild("eyelids", CubeListBuilder.create().texOffs(180, 23).addBox(6.05F, -2.0F, 0.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(212, 23).addBox(-6.05F, -2.0F, 0.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -6.0F));

		PartDefinition frontleftfoot = root.addOrReplaceChild("frontleftfoot", CubeListBuilder.create().texOffs(72, 62).addBox(-1.0F, -16.0F, -7.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 0.0F, -8.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frontleftshin = frontleftfoot.addOrReplaceChild("frontleftshin", CubeListBuilder.create().texOffs(320, 0).addBox(-4.0F, -33.0F, -6.0F, 8.0F, 34.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -16.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition frontleftknee = frontleftshin.addOrReplaceChild("frontleftknee", CubeListBuilder.create().texOffs(196, 324).addBox(-5.0F, -24.0F, -1.0F, 10.0F, 24.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition knee_top_r1 = frontleftknee.addOrReplaceChild("knee top_r1", CubeListBuilder.create().texOffs(4, 126).addBox(-11.0F, -20.0F, -1.0F, 12.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -23.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frontleftthigh = frontleftknee.addOrReplaceChild("frontleftthigh", CubeListBuilder.create().texOffs(96, 324).addBox(-5.0F, -36.0F, -3.0F, 10.0F, 36.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(46, 131).addBox(0.0F, -33.0F, -8.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.0F, 8.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition frontrightfoot = root.addOrReplaceChild("frontrightfoot", CubeListBuilder.create().texOffs(112, 62).addBox(-61.0F, -16.0F, -7.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 0.0F, -8.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frontrightshin = frontrightfoot.addOrReplaceChild("frontrightshin", CubeListBuilder.create().texOffs(320, 43).addBox(-63.0F, -33.0F, -6.0F, 8.0F, 34.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -16.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition frontrightknee = frontrightshin.addOrReplaceChild("frontrightknee", CubeListBuilder.create().texOffs(244, 324).addBox(-65.0F, -24.0F, -1.0F, 10.0F, 24.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -28.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition knee_top_r2 = frontrightknee.addOrReplaceChild("knee_top_r2", CubeListBuilder.create().texOffs(160, 126).addBox(-72.0F, -20.0F, -1.0F, 12.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -23.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition frontrightthigh = frontrightknee.addOrReplaceChild("frontrightthigh", CubeListBuilder.create().texOffs(146, 324).addBox(-65.0F, -36.0F, -3.0F, 10.0F, 36.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(160, 131).addBox(-64.0F, -33.0F, -8.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.0F, 8.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition backleftfoot = root.addOrReplaceChild("backleftfoot", CubeListBuilder.create(), PartPose.offset(23.0F, 0.0F, 56.0F));

		PartDefinition foot_front_r1 = backleftfoot.addOrReplaceChild("foot front_r1", CubeListBuilder.create().texOffs(176, 226).addBox(-7.0F, -4.0F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -4.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition foot_back_r1 = backleftfoot.addOrReplaceChild("foot back_r1", CubeListBuilder.create().texOffs(172, 236).addBox(-5.0F, -16.0F, -1.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition backleftshin = backleftfoot.addOrReplaceChild("backleftshin", CubeListBuilder.create().texOffs(0, 324).addBox(-6.0F, -30.0F, -8.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 8.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition backleftthigh = backleftshin.addOrReplaceChild("backleftthigh", CubeListBuilder.create().texOffs(220, 196).addBox(-7.0F, -46.0F, -9.0F, 14.0F, 48.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition backrightfoot = root.addOrReplaceChild("backrightfoot", CubeListBuilder.create(), PartPose.offset(-23.0F, 0.0F, 56.0F));

		PartDefinition foot_front_r2 = backrightfoot.addOrReplaceChild("foot_front_r2", CubeListBuilder.create().texOffs(20, 226).addBox(-53.0F, -4.0F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(50.0F, 0.0F, -4.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition foot_back_r2 = backrightfoot.addOrReplaceChild("foot_back_r2", CubeListBuilder.create().texOffs(16, 236).addBox(-52.0F, -16.0F, -1.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition backrightshin = backrightfoot.addOrReplaceChild("backrightshin", CubeListBuilder.create().texOffs(48, 324).addBox(-53.0F, -30.0F, -8.0F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.0F, -15.0F, 8.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition backrightthigh = backrightshin.addOrReplaceChild("backrightthigh", CubeListBuilder.create().texOffs(220, 260).addBox(-54.0F, -46.0F, -9.0F, 14.0F, 48.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
		return LayerDefinition.create(modelData, 368, 375);
	}

	@Override
	public void setupAnim(BrachiosaurusRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimationState.isStarted()){
			this.blinking.apply(state.blinkAnimationState, state.ageInTicks);
		}

		if(state.idleAnimationState.isStarted()){
			this.idle.apply(state.idleAnimationState, state.ageInTicks);
		}

		if(state.eatAnimationState.isStarted()){
			this.eat.apply(state.eatAnimationState, state.ageInTicks);
			this.leanOver.apply(state.leanDownAnimationState, state.ageInTicks);
		}

		if(state.sittingdownAnimationState.isStarted()){
			this.sitDown.apply(state.sittingdownAnimationState, state.ageInTicks);
		}
		if(state.sitAnimationState.isStarted()){
			this.sitting.apply(state.sitAnimationState, state.ageInTicks);
		}
		if(state.standingupAnimationState.isStarted()){
			this.standUp.apply(state.standingupAnimationState, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 5f); /// length of animation step / distance entity moves speed ///

		//head
		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);

		//Tail
		Float lagFactor = 0.3f;
		this.tailmiddle.xRot += (this.tailbase.xRot - this.tailmiddle.xRot) * lagFactor;
		this.tailmiddletip.xRot += (this.tailmiddle.xRot - this.tailmiddletip.xRot) * lagFactor;
		this.tailtip.xRot += (this.tailmiddletip.xRot - this.tailtip.xRot) * lagFactor;

		this.tailmiddle.yRot += (this.tailbase.yRot - this.tailmiddle.yRot) * lagFactor;
		this.tailmiddletip.yRot += (this.tailmiddle.yRot - this.tailmiddletip.yRot) * lagFactor;
		this.tailtip.yRot += (this.tailmiddletip.yRot - this.tailtip.yRot) * lagFactor;
	}
}